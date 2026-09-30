package com.basistth.RedeemCoupon.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor 
@AllArgsConstructor 
@Data 
public class NewCoupon {
    private String code;
    private int discountPercent;
    private int maxRedemptions;
    private LocalDateTime expiryDateTime;
}
