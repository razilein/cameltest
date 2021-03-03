package de.sg.cameltest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class IntegerProcessor implements Processor {

    @Override
    public void process(final Exchange exchange) throws Exception {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        exchange.getMessage().setBody(list);
    }

}
