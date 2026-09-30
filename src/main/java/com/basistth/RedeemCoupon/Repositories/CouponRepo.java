package com.basistth.RedeemCoupon.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.basistth.RedeemCoupon.Model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, UUID>{
    Optional<Coupon> findByCode(String code);
    @Query("""
    SELECT c
    FROM Coupon c
    WHERE c.active = true
      AND c.timesRedeemed < c.maxRedemptions
      AND c.expiryDateTime > CURRENT_TIMESTAMP
    """)
    List<Coupon> findAvailableCoupons();

}
