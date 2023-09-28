package com.github.ajourer.postalservice;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class Main {
    private static final Logger log = getLogger(Main.class);

    public static void main(final String[] args) {
        log.info(args.toString());
        SpringApplication.run(Main.class, args);
    }
}
