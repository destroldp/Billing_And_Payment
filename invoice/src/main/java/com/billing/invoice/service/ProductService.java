package com.billing.invoice.service;


import com.billing.invoice.entity.ProductDetails;
import com.billing.invoice.entity.Vendor;
import com.billing.invoice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDetails> getProductIds() {
        return productRepository.findAll();
    }

    public List<ProductDetails> createProductCode(List<ProductDetails> productDetails) {
        return productRepository.saveAll(productDetails);
    }

    public void deleteProductCode(Long id) {
        productRepository.deleteById(id);
    }
}
