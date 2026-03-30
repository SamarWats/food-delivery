package com.foodservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAnalyticsDTO {

    private Integer totalOrders;
    private Double totalSpend;
    private Double avgOrderValue;
	public CustomerAnalyticsDTO(Integer totalOrders, Double totalSpend, Double avgOrderValue) {
		super();
		this.totalOrders = totalOrders;
		this.totalSpend = totalSpend;
		this.avgOrderValue = avgOrderValue;
	}
    
    
}