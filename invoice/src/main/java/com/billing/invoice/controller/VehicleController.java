package com.billing.invoice.controller;

import com.billing.invoice.entity.Vehicle;
import com.billing.invoice.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVendor() {
        return vehicleService.getVehicle();
    }


    @PostMapping("/vendors")
    public ResponseEntity<Long> createVendors(@RequestBody Vehicle vehicle) {
        Vehicle createdVendors = vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(createdVendors.getId());
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updatedVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        if (updatedVehicle != null) {
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteVendor(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok(id);
    }
}
