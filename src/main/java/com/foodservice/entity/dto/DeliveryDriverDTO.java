package com.foodservice.entity.dto;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDriverDTO {
    private String driverName;
    private String driverPhone;
    private String driverVehicle;
    
}
