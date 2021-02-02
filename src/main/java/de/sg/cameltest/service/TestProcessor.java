package de.sg.cameltest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TestProcessor implements Processor {

    public static final String HEADER = "testlist";

    @Override
    public void process(final Exchange exchange) throws Exception {
        final List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        exchange.getIn().setHeader(HEADER, list);
    }

}
