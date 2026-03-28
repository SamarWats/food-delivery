package com.foodservice.controller;

import com.foodservice.entity.dto.CustomerDTO;
import com.foodservice.entity.dto.ResponseDTO;
import com.foodservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    // Get single customer
    @GetMapping("/{customerId}")
    public ResponseEntity<ResponseDTO> getCustomerById(@PathVariable Integer customerId) {
        CustomerDTO data = service.getCustomerById(customerId);

        return ResponseEntity.ok(
                new ResponseDTO(200, "Customer fetched successfully", data)
        );
    }

    // Get all customers
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCustomers() {
        List<CustomerDTO> data = service.getAllCustomers();

        return ResponseEntity.ok(
                new ResponseDTO(200, "Customers fetched successfully", data)
        );
    }

    // Get customers by city
    @GetMapping("/city")
    public ResponseEntity<ResponseDTO> getCustomersByCity(@RequestParam String city) {
        List<CustomerDTO> data = service.getCustomersByCity(city);

        return ResponseEntity.ok(
                new ResponseDTO(200, "Customers fetched by city successfully", data)
        );
    }

    // Get address count for a customer
    @GetMapping("/{customerId}/address-count")
    public ResponseEntity<ResponseDTO> getAddressCount(@PathVariable Integer customerId) {
        int count = service.getAddressCount(customerId);

        return ResponseEntity.ok(
                new ResponseDTO(200, "Address count fetched successfully", count)
        );
    }

    // Get customer analytics
    @GetMapping("/{customerId}/analytics")
    public ResponseEntity<ResponseDTO> getCustomerAnalytics(@PathVariable Integer customerId) {
        Object data = service.getCustomerAnalytics(customerId);

        return ResponseEntity.ok(
                new ResponseDTO(200, "Customer analytics fetched successfully", data)
        );
    }
}