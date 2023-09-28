package com.github.ajourer.mailservice;

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
    @Column(name="id", nullable=false)
    @Getter @Setter
    private Long id;

    @Column(name="type", nullable=false)
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
    private Integer postcode;
}
