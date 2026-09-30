package com.basistth.RedeemCoupon.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class CouponStatus {
    private int discountPercent;
    private int timesRedeemed;
    private int maxRedemptions;
    private LocalDateTime expiryDateTime;
    private Boolean active;
}
