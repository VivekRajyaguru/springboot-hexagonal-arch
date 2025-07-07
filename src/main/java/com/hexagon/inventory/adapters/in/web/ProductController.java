package com.hexagon.inventory.adapters.in.web;

import com.hexagon.inventory.domain.model.Product;
import com.hexagon.inventory.ports.in.CreateProduct;
import com.hexagon.inventory.ports.out.ProductPersistancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private CreateProduct createProduct;

    @Autowired
    private ProductPersistancePort productPersistancePort;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest request) {
        Product product = createProduct.createProduct(request.name(), request.quantity);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        return productPersistancePort.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    public record ProductRequest(String name, int quantity) {}
}
