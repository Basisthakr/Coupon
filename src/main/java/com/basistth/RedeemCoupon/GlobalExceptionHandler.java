package com.basistth.RedeemCoupon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.basistth.RedeemCoupon.Exceptions.CouponNotValidException;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CouponNotValidException.class)
    public ResponseEntity<String> handleCouponNotFound(CouponNotValidException e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This coupon does not exist!");
    }
}
