package com.billing.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class ItemDetails{

    @NotNull(message = "item description is required")
    @NotBlank(message = "item description cannot be blank")
    public String description;
    @ManyToOne
    @JoinColumn(name = "item_code_id")
    @NotNull(message = "item code is required")
    @NotBlank(message = "item code cannot be blank")
    public ProductDetails itemCode;

    @NotNull(message = "quantity is required")
    @NotBlank(message = "quantity cannot be blank")
    public String quantity;

    @NotNull(message = "unitPrice is required")
    @NotBlank(message = "unitPrice cannot be blank")
    public BigDecimal unitPrice;

    @NotNull(message = "totalPrice is required")
    @NotBlank(message = "totalPrice cannot be blank")
    public BigDecimal totalPrice;

    @NotNull(message = "discount is required")
    @NotBlank(message = "discount be blank")
    public Integer discount;
}
