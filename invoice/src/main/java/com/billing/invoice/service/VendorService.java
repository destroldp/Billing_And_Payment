package com.billing.invoice.service;

import com.billing.invoice.entity.Product;
import com.billing.invoice.entity.Vendor;
import com.billing.invoice.repository.InventoryRepository;
import com.billing.invoice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> createVendors(List<Vendor> vendors) {

        return  vendorRepository.saveAll(vendors);
    }
    public Vendor updateVendor(Long id, Vendor vendor) {
        if (vendorRepository.existsById(id)) {
            vendor.setId(id);
            return vendorRepository.save(vendor);
        }
        return null;
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
