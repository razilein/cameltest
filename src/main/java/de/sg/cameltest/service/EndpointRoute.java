package de.sg.cameltest.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class EndpointRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:endpoint").to("file:test");
    }

}
