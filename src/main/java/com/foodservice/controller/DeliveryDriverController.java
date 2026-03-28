package com.foodservice.controller;

import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DeliveryDriverController {

    private final DeliveryDriverService service;
    
    public DeliveryDriverController(DeliveryDriverService service) {
        this.service = service;
    }

	
	@GetMapping("{/driverId")
	public DeliveryDriverResponseDTO getDriverById(@PathVariable long driverId) {
		return service.getDriverById(driverId);
	}
	
	
	@GetMapping
    public List<DeliveryDriverResponseDTO> getAllDrivers() {
        return service.getAllDrivers();
    }
	
}
