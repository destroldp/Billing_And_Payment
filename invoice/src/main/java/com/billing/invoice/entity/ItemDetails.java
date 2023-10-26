package com.billing.invoice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class ItemDetails{

    public String description;
    public String itemCode;
    public String quantity;
    public BigDecimal unitPrice;
    public BigDecimal totalPrice;
    public Integer discount;
}
