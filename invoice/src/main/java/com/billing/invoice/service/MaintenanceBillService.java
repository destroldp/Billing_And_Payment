package com.billing.invoice.service;

import com.billing.invoice.entity.MaintenanceBill;
import com.billing.invoice.repository.MaintenanceBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceBillService {

    private final MaintenanceBillRepository maintenanceBillRepository;

    @Autowired
    public MaintenanceBillService(MaintenanceBillRepository maintenanceBillRepository) {
        this.maintenanceBillRepository = maintenanceBillRepository;
    }

    public List<MaintenanceBill> getAllMaintenanceBills() {
        return maintenanceBillRepository.findAll();
    }

    public MaintenanceBill getMaintenanceBillById(Long id) {
        return maintenanceBillRepository.findById(id).orElse(null);
    }

    public List<MaintenanceBill> saveMaintenanceBill(List<MaintenanceBill> maintenanceBill) {
        return maintenanceBillRepository.saveAll(maintenanceBill);
    }

    public void deleteMaintenanceBill(Long id) {
        maintenanceBillRepository.deleteById(id);
    }
}

