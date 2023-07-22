package com.example.inventorymanagementsys.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private Date date;

    public Item(String name, int quantity, Date date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public Item() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return getId() != null && Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
