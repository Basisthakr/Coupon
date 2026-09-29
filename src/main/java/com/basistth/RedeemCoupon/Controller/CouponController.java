package com.basistth.RedeemCoupon.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.basistth.RedeemCoupon.Model.Coupon;
import com.basistth.RedeemCoupon.Service.CouponService;;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor 
public class CouponController {
    
    private final CouponService couponService;

    public String createCoupon(@RequestBody Coupon c){
        try{
            couponService.createCoupon(c);
            return "Coupon created Successfully";
        }catch(Exception e){
            return "Coupon creation failed due to error: "+ e.getMessage();
        }
    }
}
