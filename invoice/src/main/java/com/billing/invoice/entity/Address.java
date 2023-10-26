package com.billing.invoice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String country;
    public String pincode;
    
}
