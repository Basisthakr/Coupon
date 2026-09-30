package com.basistth.RedeemCoupon.Exceptions;

public class CouponNotValidException extends RuntimeException{
    public CouponNotValidException(String message){
        super(message);
    }
}
