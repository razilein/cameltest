package de.sg.cameltest.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class TestRoute extends RouteBuilder {

    private static final String FROM = "quartz://testroute?trigger.repeatInterval=10&stateful=true";

    private static final String ENDPOINT = "direct:endpoint";

    @Override
    public void configure() throws Exception {
        /* @formatter:off */
        onException(RuntimeException.class, Exception.class)
          .handled(true)
          .choice()
            .when(header(TestProcessor.HEADER).isNull())
              .to(ENDPOINT)
            .otherwise()
              .setBody(header(TestProcessor.HEADER))
              // after removing the following line everything works fine
              .split(body())
              .to(ENDPOINT)
            .end()
            .markRollbackOnly()
            .stop()
        .end();
        /* @formatter:on */

        from(FROM).bean(TestProcessor.class).setBody(header(TestProcessor.HEADER)).split().body().to(ENDPOINT);
    }

}
