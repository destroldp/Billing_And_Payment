package com.billing.invoice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String invoiceNumber;
    private String customerName;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate; // Fix the Data typo to java.util.Date

    @Embedded
    private BillingInformation billingInformation; // Assuming BillingInformation is an @Embeddable class

    @ElementCollection
    private List<ItemDetails> itemDetails; // Assuming ItemDetails is an @Entity class

    private BigDecimal subtotal;
    private BigDecimal tax; // Fix the field name to follow Java naming conventions
    private BigDecimal shippingCharges;
    private BigDecimal totalAmountDue;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String additionalNotes;
}
