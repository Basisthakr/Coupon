package com.basistth.RedeemCoupon.Service;

import org.springframework.stereotype.Service;

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

    public void createCoupon(Coupon c) throws Exception//A DTO would be better suited here, but this is just for practice
    {//A DTO that checks that everything is good, then properly builds Coupon using builder would be the proper way
        couponRepo.save(c);
    }
}
