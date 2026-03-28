package com.foodservice.repository;

import com.foodservice.entity.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Long> {
	@Query("SELECT DISTINCT d FROM DeliveryDriver d JOIN FETCH d.orders")
    List<DeliveryDriver> findDriversWithOrders();

}