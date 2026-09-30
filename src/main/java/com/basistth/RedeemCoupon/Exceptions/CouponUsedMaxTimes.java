package com.basistth.RedeemCoupon.Exceptions;

public class CouponUsedMaxTimes extends RuntimeException{
    public CouponUsedMaxTimes(String message){
        super(message);
    }
}
