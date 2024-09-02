package com.softuni.resellerApp.model;

import com.softuni.resellerApp.model.entity.BaseEntity;
import com.softuni.resellerApp.model.entity.Condition;
import com.softuni.resellerApp.model.entity.Offer;

import java.math.BigDecimal;

public class OtherOffersDTO extends MyOfferDTO {

    private String sellerUsername;

    public OtherOffersDTO() {

    }

    public OtherOffersDTO(Offer offer) {
        super(offer);
        sellerUsername = offer.getCreatedBy().getUsername();
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {

        this.sellerUsername = sellerUsername;
    }


}
