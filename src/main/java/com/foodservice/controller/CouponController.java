package com.foodservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.entity.dto.OrderCouponDTO;
import com.foodservice.service.CouponService;

@RestController
@RequestMapping("/api/v1/orders")
public class CouponController {

	private CouponService couponService;

	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}

	@GetMapping("/{id}/coupons")
	public ResponseEntity<List<OrderCouponDTO>> getCoupons(@PathVariable int id) {
		List<OrderCouponDTO> coupons = couponService.getCouponsByOrder(id);

		return ResponseEntity.ok(coupons);
	}

}
