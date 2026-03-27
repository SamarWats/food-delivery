package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverDTO;
//import com.foodservice.entity.dto.OrderDeliveryDTO;
import com.foodservice.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/delivery")

public class DeliverDriverController {
    @Autowired
    private DeliveryService service;

    // -------- Get all drivers ----------
    @GetMapping("/drivers")
    public ResponseEntity<List<DeliveryDriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(service.getAllDrivers());
    }

    // ---------- Get driver by ID ------------
    @GetMapping("/drivers/{id}")
    public ResponseEntity<DeliveryDriverDTO> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDriverById(id));
    }

/*    // ---------- Get orders assigned to a driver ----------
    @GetMapping("/drivers/{id}/orders")
    public ResponseEntity<List<OrderDeliveryDTO>> getOrdersByDriver(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrdersByDriver(id));
    }

    //----------- Get orders by status --------------
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDeliveryDTO>> getOrdersByStatus(
            @RequestParam String status) {
        return ResponseEntity.ok(service.getOrdersByStatus(status));
    }*/
}