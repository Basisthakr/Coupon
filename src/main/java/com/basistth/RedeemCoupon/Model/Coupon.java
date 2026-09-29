package com.basistth.RedeemCoupon.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "coupons")
@Entity
@Getter
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class Coupon {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(unique = true)
    private String code;
    private int discountPercent;
    private int maxRedemptions;
    private int timesRedeemed;
    LocalDateTime expiryDate;
    @Builder.Default
    private Boolean active=false;
}
