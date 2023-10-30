package com.billing.invoice.repository;

import com.billing.invoice.entity.Invoice;
import com.billing.invoice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product, Long> {

}
