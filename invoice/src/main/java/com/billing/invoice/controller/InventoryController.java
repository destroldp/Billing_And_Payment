package com.billing.invoice.controller;

import com.billing.invoice.entity.Product;
import com.billing.invoice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/stock")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService  inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    public List<Product> getAllProduct() {
        return inventoryService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id) {
        Optional<Product> product = inventoryService.getInvoiceById(id);
        return product.isPresent() ? ResponseEntity.ok(product): ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found with Product ID"+id);
    }

    @PostMapping("/stockin")
    public ResponseEntity<List<Long>> createProducts(@RequestBody List<Product> products) {
        List<Product> createdProduct = inventoryService.createProducts(products);

        return ResponseEntity.ok(createdProduct.stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = inventoryService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/stockOut/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
        inventoryService.deleteProduct(id);
        return ResponseEntity.ok(id);
    }
}
