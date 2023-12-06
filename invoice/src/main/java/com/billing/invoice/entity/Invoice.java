package com.billing.invoice.entity;

import jakarta.persistence.*;
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
    private Date invoiceDate;

    @Embedded
    private BillingInformation billingInformation;

    @ElementCollection
    private List<ItemDetails> itemDetails;

    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal shippingCharges;
    private BigDecimal totalAmountDue;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String additionalNotes;

    private String createdBy;

    private String modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
}
