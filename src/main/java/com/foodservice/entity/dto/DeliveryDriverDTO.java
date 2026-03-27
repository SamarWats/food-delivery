package com.foodservice.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDriverDTO {

    private Long driverId;
    private String driverName;
    private String driverPhone;
    private String driverVehicle;
}