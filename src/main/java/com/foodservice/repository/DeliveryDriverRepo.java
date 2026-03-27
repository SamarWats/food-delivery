package com.foodservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodservice.entity.DeliveryDriver;
import com.foodservice.entity.dto.DeliveryDriverDTO;

public interface DeliveryDriverRepo extends JpaRepository<DeliveryDriver, Long> {

	Collection<DeliveryDriverDTO> findByDeliveryDriverDriverId(Long driverId);
}