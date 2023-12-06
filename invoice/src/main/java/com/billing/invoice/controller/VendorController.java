package com.billing.invoice.controller;

import com.billing.invoice.entity.Vendor;
import com.billing.invoice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService  vendorService) {
        this.vendorService = vendorService;
    }


    @GetMapping
    public List<Vendor> getAllVendor() {
        return vendorService.getVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity getVendorById(@PathVariable Long id) {
        Optional<Vendor> vendor = vendorService.getVendorById(id);
        return vendor.isPresent() ? ResponseEntity.ok(vendor): ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Vendor found with Vendor ID"+id);
    }



    @PostMapping("/vendors")
    public ResponseEntity<List<Long>> createVendors(@RequestBody List<Vendor> vendors) {
        List<Vendor> createdVendors = vendorService.createVendors(vendors);
        return ResponseEntity.ok(createdVendors.stream()
                .map(Vendor::getId)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        Vendor updatedVendor = vendorService.updateVendor(id, vendor);
        if (updatedVendor != null) {
            return ResponseEntity.ok(updatedVendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok(id);
    }
}
