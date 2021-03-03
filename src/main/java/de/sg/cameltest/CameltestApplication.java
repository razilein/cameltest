package de.sg.cameltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CameltestApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CameltestApplication.class, args);
    }

}
