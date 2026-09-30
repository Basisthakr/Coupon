package com.basistth.RedeemCoupon.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.basistth.RedeemCoupon.DTO.CouponCreated;
import com.basistth.RedeemCoupon.DTO.NewCoupon;
import com.basistth.RedeemCoupon.DTO.RedeemStatus;
import com.basistth.RedeemCoupon.Service.CouponService;;

@RestController
@RequestMapping("/api/v1/Coupon")
@RequiredArgsConstructor 
public class CouponController {
    
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<CouponCreated> createCoupon(@RequestBody NewCoupon c){
        return ResponseEntity.status(HttpStatus.CREATED).body(couponService.createCoupon(c));
    }

    @PostMapping("/{code}/redeem")
    public ResponseEntity<RedeemStatus> redeemCoupon(@PathVariable String code){
        couponService.redeemCoupon(code)
        return ResponseEntity.status(HttpStatus.OK).body(new RedeemStatus("The coupon has been successfully redeemed!"));
    }
}
