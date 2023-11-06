package com.billing.invoice.controller;


import com.billing.invoice.entity.Product;
import com.billing.invoice.entity.ProductDetails;
import com.billing.invoice.service.InventoryService;
import com.billing.invoice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService  productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDetails> getAllProductId() {
        return productService.getProductIds();
    }

    @PostMapping("/productId")
    public ResponseEntity<List<Long>> createProductId(@RequestBody List<ProductDetails> productDetails) {
        List<ProductDetails> createdProduct = productService.createProductCode(productDetails);
        return ResponseEntity.ok(productDetails.stream()
                .map(ProductDetails::getId)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
        productService.deleteProductCode(id);
        return ResponseEntity.ok(id);
    }

}
