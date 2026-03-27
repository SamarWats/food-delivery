package com.foodservice.service.impl;

import com.foodservice.entity.dto.DeliveryDriverDTO;
//import com.foodservice.dto.OrderDeliveryDTO;
import com.foodservice.entity.DeliveryDriver;
//import com.foodservice.entity.Order;
//import com.foodservice.mapper.DeliveryDriverMapper;
//import com.foodservice.mapper.DeliveryOrderMapper;
//import com.foodservice.repository.OrderRepository;
import com.foodservice.service.DeliveryDriverService;

import lombok.RequiredArgsConstructor;

import com.foodservice.repository.DeliveryDriverRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final DeliveryDriverRepo driverRepository;

//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private DeliveryDriverMapper driverMapper;
//
//    @Autowired
//    private DeliveryOrderMapper orderMapper;

    //  ------------ Get all drivers -------------
    @Override
    public List<DeliveryDriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream().map(driverMapper::toDTO).toList();
    }

    //  ------------ Get all drivers by id-------------
    @Override
    public DeliveryDriverDTO getDriverById(Long id) {
        DeliveryDriver driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));

        return driverMapper.toDTO(driver);
    }

    //  ------------ Get orders assigned to a driver-------------
    @Override
    public List<OrderDeliveryDTO> getOrdersByDriver(Long driverId) {
        return orderRepository.findByDeliveryDriver_DriverId(driverId).stream().map(orderMapper::toDTO).toList();
    }

    //  ------------ Get orders by status -------------
    @Override
    public List<OrderDeliveryDTO> getOrdersByStatus(String status) {
        return orderRepository.findByOrderStatus(status).stream().map(orderMapper::toDTO).toList();
    }
}