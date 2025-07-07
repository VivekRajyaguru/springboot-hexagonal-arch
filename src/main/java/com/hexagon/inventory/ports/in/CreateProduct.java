package com.hexagon.inventory.ports.in;

import com.hexagon.inventory.domain.model.Product;

public interface CreateProduct {
    Product createProduct(String name, int quantity);
}
