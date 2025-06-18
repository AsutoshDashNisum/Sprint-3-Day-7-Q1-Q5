package com.example.calculator.controller;

import com.example.calculator.model.ProductQ4;
import com.example.calculator.repository.ProductRepositoryQ4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductControllerQ4 {

    @Autowired
    private ProductRepositoryQ4 productRepository;

    @GetMapping
    public List<ProductQ4> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductQ4> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductQ4 createProduct(@RequestBody ProductQ4 product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductQ4> updateProduct(@PathVariable Long id, @RequestBody ProductQ4 productDetails) {
        Optional<ProductQ4> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductQ4 product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setStockQuantity(productDetails.getStockQuantity());
            product.setCategory(productDetails.getCategory());
            return ResponseEntity.ok(productRepository.save(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
