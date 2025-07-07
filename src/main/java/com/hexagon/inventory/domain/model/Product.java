package com.hexagon.inventory.domain.model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private int quantity;

    public Product(UUID id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        if (quantity < amount) throw new IllegalArgumentException("Insufficient Quantity");
        this.quantity -= amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
