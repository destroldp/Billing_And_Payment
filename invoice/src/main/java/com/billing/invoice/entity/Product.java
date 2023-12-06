package com.billing.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @ManyToOne
    private ProductDetails productId;

    @NotNull(message = "Cost price is required")
    private BigDecimal costPrice;


    private BigDecimal salePrice;

    @NotNull(message = "quantity is required")
    private BigDecimal quantity;
    private BigDecimal remainingQuantity;

    @NotNull(message = "Product Total is required")
    private BigDecimal productTotal;
    @ManyToOne
    private Vendor vendorDetails;
    private String productName;

    private String softDelete;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
}
