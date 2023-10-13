package com.github.ajourer.postalservice;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import static org.slf4j.LoggerFactory.getLogger;

@PropertySource("classpath:/application.properties")
@SpringBootApplication
public class Main {
    private static final Logger log = getLogger(Main.class);

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner getCommandLineRunner(
        final PostOfficeRepository postOfficeRepository,
    ) {
        return args -> {
            final var postOffice = new PostOffice();
            postOffice.setAddress("г Москва, ул Мясницкая, дом 26А стр. 1");
            postOffice.setName("Почтовое отделение № 101000");
            postOffice.setPostcode(101000);
            repository.save(postOffice);
            log.info(postOffice);
        };
    }
}
