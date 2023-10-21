package com.github.ajourer.postalservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="PostOffice")
@Table(name="post_office", schema="public")
@NoArgsConstructor
@ToString
public class PostOffice {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(
        insertable=true,
        name="postcode",
        nullable=false,
        table="post_office",
        updatable=false
    )
    @Getter @Setter
    private Integer postcode;

    @Column(name="name", nullable=false, table="post_office", unique=true)
    @Getter @Setter
    private String name;

    @Column(name="address", nullable=false, table="post_office", unique=true)
    @Getter @Setter
    private String address;
}
