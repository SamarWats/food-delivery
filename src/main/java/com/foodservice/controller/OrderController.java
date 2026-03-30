package com.foodservice.controller;

import com.foodservice.entity.Order;
import com.foodservice.entity.dto.DeliveryDriverResponseDTO;
import com.foodservice.entity.dto.OrderCustomerDTO;
import com.foodservice.entity.dto.OrderDTO;
import com.foodservice.entity.dto.ResponseDTO;
import com.foodservice.service.DeliveryDriverService;
import com.foodservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseDTO> getOrdersByCustomerId(@PathVariable Integer customerId) {
        OrderCustomerDTO orderDTO = orderService.getOrdersByCustomerId(customerId);
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(200, "customer having id: "+customerId+" has " + orderDTO.getOrderItems().size() + " order", orderDTO));
    }

    @GetMapping("/detail/{orderId}")
    public ResponseEntity<ResponseDTO> getOrderDetailsById(@PathVariable Integer orderId) {
        OrderDTO orderDTO = orderService.getOrderDetailsById(orderId);

        return ResponseEntity
                .status(200)
                .body(new ResponseDTO(200, "order detail having id: " + orderId, orderDTO));
    }
    
    
    @GetMapping("/{orderId}/driver")
    public ResponseEntity<ResponseDTO> getDriverByOrder(@PathVariable Integer orderId) {

        DeliveryDriverResponseDTO dto = orderService.getDriverByOrderId(orderId);

        return ResponseEntity.ok(new ResponseDTO(200, "Driver fetched for order", dto)
        );
    }
    
}
