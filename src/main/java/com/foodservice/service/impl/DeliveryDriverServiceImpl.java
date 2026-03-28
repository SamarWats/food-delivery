package com.foodservice.service.impl;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.exception.DriverNotFoundException;
import com.foodservice.repository.DeliveryDriverRepository;
import com.foodservice.service.DeliveryDriverService;
import com.foodservice.config.CustomMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final DeliveryDriverRepository repo;
    
    public DeliveryDriverServiceImpl(DeliveryDriverRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeliveryDriverResponseDTO getDriverById(Long id) {
        DeliveryDriver driver = repo.findById(id).orElseThrow(() -> new DriverNotFoundException("Driver Not Found"));
        return CustomMapper.deliveryDriverToDTO(driver);
    }

    @Override
    public List<DeliveryDriverResponseDTO> getAllDrivers() {
        return repo.findAll().stream().map(CustomMapper::deliveryDriverToDTO).toList();
    }

    @Override
    public List<DeliveryDriver> getDriversWithOrders() {
        return repo.findDriversWithOrders();
    }
}