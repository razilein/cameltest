package de.sg.cameltest.service;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;
import org.springframework.stereotype.Service;

@Service
public class TestRoute extends RouteBuilder {

    private static final String FROM = "quartz://testroute?trigger.repeatInterval=10&stateful=true";

    private static final String ENDPOINT = "direct:endpoint";

    @Override
    public void configure() throws Exception {
        /* @formatter:off */
        from(FROM)
          // when deactivate transacted everything is fine an MyStrategy is used.
          // when activate transacted, MyStrategy is completly ignored.
          .transacted()
          .bean(IntegerProcessor.class)
          .split(body(), new MyStrategy())
            .bean(StringConverter.class)
          .end()
          .split(body(), new MyStrategy())
            .bean(LogTypeProcessor.class)
            .to(ENDPOINT);
        /* @formatter:on */
    }

    public final class MyStrategy extends AbstractListAggregationStrategy<String> {

        @Override
        public String getValue(final Exchange exchange) {
            return exchange.getIn().getBody(String.class);
        }
    }

}
