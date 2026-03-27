package com.foodservice.service;

import com.foodservice.entity.dto.DeliveryDriverDTO;

import java.util.List;

public interface DeliveryDriverService {

    // Get all drivers
    List<DeliveryDriverDTO> getAllDrivers();

    // Get driver by ID
    DeliveryDriverDTO getDriverById(Long id);

//    // Get orders assigned to a driver
//    List<OrderDeliveryDTO> getOrdersByDriver(Long driverId);
//
//    // Get orders by status
//    List<OrderDeliveryDTO> getOrdersByStatus(String status);
}