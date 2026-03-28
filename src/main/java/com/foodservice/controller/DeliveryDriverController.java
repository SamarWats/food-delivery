package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverDTO;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {
	
	
	private final DeliveryDriverService deliveryDriverservice=null;

    // ------- Get Driver by ID ----------
    @GetMapping("/{driverId}")
    public ResponseEntity<DeliveryDriverDTO> getDriverById(@PathVariable Integer driverId) {
        return ResponseEntity.ok(deliveryDriverservice.getDriverById(driverId));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(deliveryDriverservice.getAllDrivers());
    }

    //------- Get Driver Deliveries ----------
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<List<DeliveryDriverResponseDTO>> getDriverDeliveries(@PathVariable Long driverId) {
        return ResponseEntity.ok(deliveryDriverservice.getDriverDeliveries(driverId));
    }
}