package com.foodservice.entity.dto;

import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDriverResponseDTO {
	private Long driverId;
	private String driverName;
	private String driverPhone;
	private String driverVehicle;
}
