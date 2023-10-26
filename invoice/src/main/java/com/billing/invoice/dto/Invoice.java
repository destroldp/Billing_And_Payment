package com.billing.invoice.dto;


import com.billing.invoice.entity.BillingInformation;
import com.billing.invoice.entity.ItemDetails;
import com.billing.invoice.entity.PaymentMethod;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Invoice {
    public String invoiceNumber;
    public String customerName;

}
