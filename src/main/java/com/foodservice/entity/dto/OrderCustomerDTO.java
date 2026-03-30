package com.foodservice.entity.dto;

import com.foodservice.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class OrderCustomerDTO {
    private Customer customer;
    private List<OrderItemDetailDTO> orderItems;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItemDetailDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDetailDTO> orderItems) {
		this.orderItems = orderItems;
	}
}
