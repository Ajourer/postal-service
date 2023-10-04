package com.github.ajourer.postalservice;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import static org.slf4j.LoggerFactory.getLogger;

import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Main {
    private static final Logger log = getLogger(Main.class);

    public static void main(final String[] args) throws SQLException {
        try(
            final var connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postal_service",
                "postal_service",
                "a2{O)9U%V+Lt~dnMykSPG1?sF8Wf:p0H"
            );
            final var statement = connection.createStatement()
        ) {
            final var result = statement.executeQuery(
                "SELECT * FROM pg_catalog.pg_user"
            );
            System.out.println(result.next());
            System.out.println(result.getString(1));
        }
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
