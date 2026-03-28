package com.foodservice.service;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;

import java.util.List;

public interface DeliveryDriverService {

	DeliveryDriverResponseDTO getDriverById(Long id);
	List<DeliveryDriverResponseDTO> getAllDrivers();
    List<DeliveryDriver> getDriversWithOrders();
    
}