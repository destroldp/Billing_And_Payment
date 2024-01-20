package com.billing.invoice.controller;

// MaintenanceBillController.java
import com.billing.invoice.entity.MaintenanceBill;
import com.billing.invoice.service.MaintenanceBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenance-bills")
public class MaintenanceBillController {

    private final MaintenanceBillService maintenanceBillService;

    @Autowired
    public MaintenanceBillController(MaintenanceBillService maintenanceBillService) {
        this.maintenanceBillService = maintenanceBillService;
    }

    @GetMapping
    public List<MaintenanceBill> getAllMaintenanceBills() {
        return maintenanceBillService.getAllMaintenanceBills();
    }

    @GetMapping("/{id}")
    public MaintenanceBill getMaintenanceBillById(@PathVariable Long id) {
        return maintenanceBillService.getMaintenanceBillById(id);
    }

    @PostMapping
    public List<MaintenanceBill> saveMaintenanceBill(@RequestBody List<MaintenanceBill> maintenanceBill) {
        return maintenanceBillService.saveMaintenanceBill(maintenanceBill);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenanceBill(@PathVariable Long id) {
        maintenanceBillService.deleteMaintenanceBill(id);
    }
}

