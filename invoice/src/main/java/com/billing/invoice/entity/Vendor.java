package com.billing.invoice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Setter
@Getter
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String VendorId;
    @Embedded
    private Address vendorAddress;

    private String vendorName;

    private String vendorCompany;

    @Embedded
    private ContactDetails vendorContactDetails;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;

}
