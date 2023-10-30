package com.billing.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Product ID is required")
    private String productId;

    @NotNull(message = "Cost price is required")
    private BigDecimal costPrice;

    @NotNull(message = "quantity is required")
    private BigDecimal quantity;

    @NotNull(message = "Product Total is required")
    private BigDecimal productTotal;
    @ManyToOne
    private Vendor vendorDetails;
    private String productName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
}
