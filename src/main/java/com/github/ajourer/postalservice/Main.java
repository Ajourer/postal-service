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
        final PostalItemRepository repository
    ) {
        return args -> {
            final var postalItem = repository.findById(0);
            log.info(postalItem.toString());
            repository.save(new PostalItem(ItemType.LETTER, 460001));
        };
    }
}
/*
package com.github.ajourer.postalservice;

import org.springframework.data.repository.CrudRepository;

public interface PostalItemRepository extends CrudRepository<PostalItem, Long> {
    PostalItem findById(long id);
}

package com.github.ajourer.postalservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="PostalItem")
@Table(name="postal_item")
@NoArgsConstructor
@ToString
public class PostalItem {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, table="postal_item")
    @Getter @Setter
    private Long id;

    @Column(name="type", nullable=false, table="postal_item")
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @ManyToOne(optional=false)
    @JoinColumn(
        name="postcode",
        nullable=false,
        referencedColumnName="postcode",
        table="post_office"
    )
    @Getter @Setter
    private PostOffice postOffice;

    public PostalItem(final ItemType type, final Integer postcode) {
        this.type = type;
        this.postcode = postcode;
    }
}
*/
