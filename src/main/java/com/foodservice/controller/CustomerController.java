package com.foodservice.controller;

import com.foodservice.entity.dto.ResponseDTO;
import com.foodservice.service.CustomerService;
import com.foodservice.constants.CustomerConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
    	this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ResponseDTO> getCustomerById(@PathVariable Integer customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(
                        CustomerConstant.STATUS_200,
                        CustomerConstant.MESSAGE_CUSTOMER_FETCHED,
                        customerService.getCustomerById(customerId)
                ));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCustomers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(
                        CustomerConstant.STATUS_200,
                        CustomerConstant.MESSAGE_CUSTOMERS_FETCHED,
                        customerService.getAllCustomers()
                ));
    }

    @GetMapping("/city")
    public ResponseEntity<ResponseDTO> getCustomersByCity(@RequestParam String city) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(
                        CustomerConstant.STATUS_200,
                        CustomerConstant.MESSAGE_CUSTOMERS_FETCHED_BY_CITY,
                        customerService.getCustomersByCity(city)
                ));
    }

    @GetMapping("/{customerId}/address-count")
    public ResponseEntity<ResponseDTO> getAddressCount(@PathVariable Integer customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(
                        CustomerConstant.STATUS_200,
                        CustomerConstant.MESSAGE_ADDRESS_COUNT_FETCHED,
                        customerService.getAddressCount(customerId)
                ));
    }

    @GetMapping("/{customerId}/analytics")
    public ResponseEntity<ResponseDTO> getCustomerAnalytics(@PathVariable Integer customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(
                        CustomerConstant.STATUS_200,
                        CustomerConstant.MESSAGE_CUSTOMER_ANALYTICS_FETCHED,
                        customerService.getCustomerAnalytics(customerId)
                ));
    }
}