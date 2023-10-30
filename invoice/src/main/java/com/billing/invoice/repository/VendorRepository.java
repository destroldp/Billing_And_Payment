package com.billing.invoice.repository;

import com.billing.invoice.entity.Invoice;
import com.billing.invoice.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
