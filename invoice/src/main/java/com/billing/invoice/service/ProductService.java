package com.billing.invoice.service;


import com.billing.invoice.entity.ProductDetails;
import com.billing.invoice.repository.ProductRepository;
import jakarta.validation.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

@Service
@Validated
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDetails> getProductIds() {
        return productRepository.findAll();
    }

    public List<ProductDetails> createProductCode( List<ProductDetails> productDetails) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<List<ProductDetails>>> violations = validator.validate(productDetails);

        return productRepository.saveAll(productDetails);
    }

    public void deleteProductCode(Long id) {
        productRepository.deleteById(id);
    }
}
