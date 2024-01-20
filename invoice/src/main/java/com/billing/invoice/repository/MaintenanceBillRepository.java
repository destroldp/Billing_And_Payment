package com.billing.invoice.repository;


import com.billing.invoice.entity.MaintenanceBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceBillRepository extends JpaRepository<MaintenanceBill, Long> {

}

