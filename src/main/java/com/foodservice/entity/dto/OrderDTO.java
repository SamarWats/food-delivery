package com.foodservice.entity.dto;

import com.foodservice.entity.Customer;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private CustomerDTO customer;
    private RestaurantResponseDTO restaurant;
    private DeliveryDriverDTO deliveryDriver;
    private LocalDateTime orderDate;
    private String orderStatus;
    private List<OrderItemDetailDTO> orderItems;
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public RestaurantResponseDTO getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(RestaurantResponseDTO restaurant) {
		this.restaurant = restaurant;
	}
	public DeliveryDriverDTO getDeliveryDriver() {
		return deliveryDriver;
	}
	public void setDeliveryDriver(DeliveryDriverDTO deliveryDriver) {
		this.deliveryDriver = deliveryDriver;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderItemDetailDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDetailDTO> orderItems) {
		this.orderItems = orderItems;
	}
}
