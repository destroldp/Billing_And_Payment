package com.billing.invoice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class BillingInformation {

    public String name;
    @Embedded
    public Address address;
    @Embedded
    public ContactDetails contactDetails;
}

