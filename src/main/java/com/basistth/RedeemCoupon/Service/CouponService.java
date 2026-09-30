package com.basistth.RedeemCoupon.Service;

import java.time.LocalDateTime;

import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.basistth.RedeemCoupon.DTO.CouponCreated;
import com.basistth.RedeemCoupon.DTO.NewCoupon;
import com.basistth.RedeemCoupon.Exceptions.CouponNotValidException;
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

    public CouponCreated createCoupon(NewCoupon c) throws Exception
    {
        if(c.getExpiryDateTime().isBefore(LocalDateTime.now().plusDays(1))){
            throw new IllegalArgumentException("The expiry date for the coupon must be atleast 1 day from now");
        }
        Coupon nc = Coupon.builder().code(c.getCode())
                                    .discountPercent(c.getDiscountPercent())
                                    .maxRedemptions(c.getMaxRedemptions())
                                    .expiryDateTime(c.getExpiryDateTime()).build();

        Coupon savedCoupon = couponRepo.save(nc);
        return CouponCreated.builder().id(savedCoupon.getId()).build();
    }

    @Retryable(maxRetries = 3)//Apparently they removed retryFor = OptimisticEntityLockException.class
    public void redeemCoupon(String code){
        Coupon c = couponRepo.findByCode(code).orElseThrow(() ->new CouponNotValidException("This Coupon is invalid!"));
        if(c.getActive()==false || c.getExpiryDateTime().isBefore(LocalDateTime.now()) || c.getTimesRedeemed()>=c.getMaxRedemptions()){
            throw new CouponNotValidException("This Coupon is invalid!");
        }
        c.setTimesRedeemed(c.getTimesRedeemed()+1);
        couponRepo.save(c);
    }
}
