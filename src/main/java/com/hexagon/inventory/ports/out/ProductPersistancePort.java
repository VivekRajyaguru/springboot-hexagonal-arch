package com.hexagon.inventory.ports.out;

import com.hexagon.inventory.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductPersistancePort {
    Product save(Product product);
    Optional<Product> findById(UUID id);
}
