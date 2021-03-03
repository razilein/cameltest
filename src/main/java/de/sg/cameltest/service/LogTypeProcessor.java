package de.sg.cameltest.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogTypeProcessor implements Processor {

    @Override
    public void process(final Exchange exchange) throws Exception {
        final Object value = exchange.getIn().getMandatoryBody();

        if (value instanceof String) {
            System.out.println("Value is type String: true");
        } else {
            System.err.println("Value is type String: false");
        }
    }

}
