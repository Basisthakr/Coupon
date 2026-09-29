package com.basistth.RedeemCoupon.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basistth.RedeemCoupon.Model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, UUID>{
    
}
