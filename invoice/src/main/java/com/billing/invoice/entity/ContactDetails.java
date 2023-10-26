package com.billing.invoice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactDetails {
    private Long contactDetailsId;
    public String phoneNumber;
    public String email;

}
