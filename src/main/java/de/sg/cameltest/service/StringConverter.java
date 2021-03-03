package de.sg.cameltest.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class StringConverter implements Processor {

    @Override
    public void process(final Exchange exchange) throws Exception {
        final Integer value = exchange.getIn().getMandatoryBody(Integer.class);
        exchange.getMessage().setBody(String.valueOf(value));
    }

}
