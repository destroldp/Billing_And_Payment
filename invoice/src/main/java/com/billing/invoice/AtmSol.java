package com.billing.invoice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AtmSol{

    public Integer personId;
    public Integer amount;

    public AtmSol(Integer personId,Integer amount) {
        this.personId=personId;
        this.amount=amount;
    }
}
