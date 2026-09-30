package com.basistth.RedeemCoupon.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.basistth.RedeemCoupon.DTO.NewCoupon;
import com.basistth.RedeemCoupon.Model.Coupon;
import com.basistth.RedeemCoupon.Repositories.CouponRepo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service 
@RequiredArgsConstructor 
@Getter 
@Setter 
public class CouponService {
    
    private final CouponRepo couponRepo;

    public void createCoupon(NewCoupon c) throws Exception
    {
        if(c.getExpiryDateTime().isBefore(LocalDateTime.now().plusDays(1))){
            throw new IllegalArgumentException("The expiry date for the coupon must be atleast 1 day from now");
        }
        Coupon nc = Coupon.builder().code(c.getCode())
                                    .discountPercent(c.getDiscountPercent())
                                    .maxRedemptions(c.getMaxRedemptions())
                                    .expiryDateTime(c.getExpiryDateTime()).build();

        couponRepo.save(nc);
    }
}
