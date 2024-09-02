package com.softuni.resellerApp.model;

import com.softuni.resellerApp.model.entity.Condition;
import com.softuni.resellerApp.model.entity.Offer;
import com.softuni.resellerApp.model.enums.ConditionName;

import java.math.BigDecimal;
import java.util.UUID;

public class MyOfferDTO extends BoughtOffersDTO {
    private ConditionName condition;
    private UUID id;

    public MyOfferDTO() {
    }
    public MyOfferDTO(Offer offer){
        super(offer);
        id = offer.getId();
       condition = offer.getCondition().getName();

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }


}
