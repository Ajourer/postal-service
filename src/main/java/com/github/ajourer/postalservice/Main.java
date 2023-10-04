package com.github.ajourer.postalservice;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:/application.properties")
public class Main {
    private static final Logger log = getLogger(Main.class);

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner getCommandLineRunner(
        final PostalItemRepository repository
    ) {
        return args -> {
            final var postalItem = repository.findById(0);
            log.info(postalItem.toString());
            repository.save(new PostalItem(ItemType.LETTER, 460001));
        };
    }
}
