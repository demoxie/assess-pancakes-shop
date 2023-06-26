package com.saultech.pancakeshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class Pancake {
    private UUID id;
    private String name;
    private int quantity;
    private double price;

    public Pancake() {
    }

    public Pancake(String name, int quantity, double price) {
        this.id  = UUID.randomUUID();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pancake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
