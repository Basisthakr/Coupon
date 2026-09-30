package com.basistth.RedeemCoupon.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Column(unique = true,nullable = false)
    @NotBlank
    @Pattern(
        regexp = "^[a-zA-Z0-9]{4,15}$",
        message = "Code must contain only letters and digits and be 4–15 characters long"
    )
    private String code;
    @Min(1)
    @Max(100)
    private int discountPercent;
    @Min(1)
    private int maxRedemptions;
    private int timesRedeemed;
    @Column(nullable = false)
    @Future
    private LocalDateTime expiryDateTime;
    @Builder.Default
    private Boolean active=false;

    @Version
    private Long version;
}
