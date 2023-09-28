package com.github.ajourer.postalservice;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
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
