package com.billing.invoice.service;

import com.billing.invoice.entity.Invoice;
import com.billing.invoice.entity.Product;
import com.billing.invoice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService  {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Product> getProducts() {
        return inventoryRepository.findAll();
    }

    public Optional<Product> getInvoiceById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return inventoryRepository.save(product);
    }

    public List<Product> createProducts(List<Product> products) {
  
        return  inventoryRepository.saveAll(products);
    }
    public Product updateProduct(Long id, Product product) {
        if (inventoryRepository.existsById(id)) {
            product.setId(id);
            return inventoryRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        inventoryRepository.deleteById(id);
    }

}
