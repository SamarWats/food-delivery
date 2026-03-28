package com.foodservice.service;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.entity.dto.DeliveryDriverDTO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DeliveryDriverService {

	DeliveryDriverDTO getDriverById(Long id);
	List<DeliveryDriverDTO> getAllDrivers();
	List<DeliveryDriverResponseDTO> getDriverDeliveries(Long driverId);
}