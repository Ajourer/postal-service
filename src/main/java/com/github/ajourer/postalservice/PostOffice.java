package com.github.ajourer.postalservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="PostOffice")
@Table(catalog="postal_service", name="post_office")
@NoArgsConstructor
@ToString
public class PostOffice {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="postcode", nullable=false, table="post_office")
    @Getter @Setter
    private Integer postcode;

    @Column(name="name", nullable=false, table="post_office")
    @Getter @Setter
    private String name;

    @Column(name="address", nullable=false, table="post_office")
    @Getter @Setter
    private String address;
}
