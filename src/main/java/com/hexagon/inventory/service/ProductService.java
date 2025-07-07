package com.hexagon.inventory.service;

import com.hexagon.inventory.domain.model.Product;
import com.hexagon.inventory.ports.in.CreateProduct;
import com.hexagon.inventory.ports.out.ProductPersistancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService implements CreateProduct {

    @Autowired
    private ProductPersistancePort productPersistancePort;


    @Override
    public Product createProduct(String name, int quantity) {
        Product product = new Product(UUID.randomUUID(), name, quantity);
        return productPersistancePort.save(product);
    }
}
