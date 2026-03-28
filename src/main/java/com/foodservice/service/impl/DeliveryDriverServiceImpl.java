package com.foodservice.service.impl;

import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Order;
import com.foodservice.entity.dto.DeliveryDriverDTO;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.exception.DriverNotFoundException;
import com.foodservice.repository.DeliveryDriverRepository;
import com.foodservice.repository.OrderRepository;
import com.foodservice.service.DeliveryDriverService;
import com.foodservice.config.CustomMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

	private final DeliveryDriverRepository deliveryDriverRepository;
	private final OrderRepository orderRepository;
	
	@Override
	public DeliveryDriverDTO getDriverById(Long id) {
	    DeliveryDriver driver = deliveryDriverRepository.findById(id)
	            .orElseThrow(() -> new DriverNotFoundException("Driver Not Found"));

	    return CustomMapper.deliveryDriverToDTO(driver);
	}

	@Override
	public List<DeliveryDriverDTO> getAllDrivers() {
	    return deliveryDriverRepository.findAll()
	            .stream()
	            .map(CustomMapper::deliveryDriverToDTO)
	            .toList();
	}

//    @Override
//    public List<DeliveryDriverResponseDTO> getDriverDeliveries(Long driverId) {
//
//        List<Order> orders = orderRepository.findOrdersByDriverId(driverId);
//
//        return orders.stream().map(order -> new DriverDeliveryResponseDTO(
//                order.getOrderId(),
//                order.getCustomer().getCustomerName(),
//                order.getRestaurant().getRestaurantName(),
//                order.getOrderStatus()
//        )).toList();
//    }

	@Override
	public List<DeliveryDriverResponseDTO> getDriverDeliveries(Long driverId) {

	    List<Order> orders = orderRepository.findOrdersByDriverId(driverId);

	    return orders.stream().map(order -> {

	        String customerName = (order.getCustomer() != null)
	                ? order.getCustomer().getCustomerName()
	                : "N/A";

	        String restaurantName = (order.getRestaurant() != null)
	                ? order.getRestaurant().getRestaurantName()
	                : "N/A";

	        return new DeliveryDriverResponseDTO(
	                order.getOrderId(),
	                customerName,
	                restaurantName,
	                order.getOrderStatus()
	        );

	    }).toList();   // ✅ CORRECT CLOSING
	}
    
//	@Override
//	public List<DeliveryDriver> getDriversWithOrders() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}