package com.billing.invoice.entity;

import com.billing.invoice.CustomEnums.BillTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Embeddable
public class MaintenanceBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private String billingDate;
    private BillTypes Type;

}

