package com.hexagon.inventory.adapters.out.persistance;

import com.hexagon.inventory.domain.model.Product;
import com.hexagon.inventory.ports.out.ProductPersistancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProductJpaAdapter implements ProductPersistancePort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.getId(), product.getName(), product.getQuantity());
        productRepository.save(entity);
        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id).map(e -> new Product(e.getId(), e.getName(), e.getQuantity()));
    }
}
