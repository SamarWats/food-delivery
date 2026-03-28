package com.foodservice.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDriverResponseDTO {
    Integer orderId;
    String customerName;
    String restaurantName;
    String orderStatus;
    
    
}