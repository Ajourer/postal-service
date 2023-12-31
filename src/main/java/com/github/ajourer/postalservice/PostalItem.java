package com.github.ajourer.postalservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name="postal_item", schema="public")
@NoArgsConstructor
@ToString
public class PostalItem {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(
        insertable=false,
        name="id",
        nullable=false,
        table="postal_item",
        updatable=false
    )
    @Getter @Setter
    private Long id;

    @Column(
        insertable=true,
        length=8,
        name="type",
        nullable=false,
        table="postal_item",
        updatable=false
    )
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private ItemType type;

    @ManyToOne(
        optional=false,
        fetch=FetchType.LAZY,
        targetEntity=PostOffice.class
    )
    @JoinColumn(
        name="postcode",
        nullable=false,
        referencedColumnName="postcode",
        table="postal_item"
    )
    @Getter @Setter
    private PostOffice postOffice;
/*
    public PostalItem(final ItemType type, final Integer postcode) {
        this.type = type;
        this.postcode = postcode;
    }
*/
}
