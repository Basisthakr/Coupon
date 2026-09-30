package com.basistth.RedeemCoupon.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.basistth.RedeemCoupon.DTO.CouponCreated;
import com.basistth.RedeemCoupon.DTO.NewCoupon;
import com.basistth.RedeemCoupon.Service.CouponService;;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor 
public class CouponController {
    
    private final CouponService couponService;

    @PostMapping("/Coupon")
    public ResponseEntity<CouponCreated> createCoupon(@RequestBody NewCoupon c){
        return ResponseEntity.status(HttpStatus.CREATED).body(couponService.createCoupon(c));
    }
}
