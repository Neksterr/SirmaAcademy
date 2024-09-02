package com.softuni.resellerApp.service;


import com.softuni.resellerApp.model.OfferCreateBindingModel;
import com.softuni.resellerApp.model.OfferHomeDTO;

import java.util.UUID;

public interface OfferService {
    OfferHomeDTO getOffersForHomePage();

    boolean create(OfferCreateBindingModel offerCreateBindingModel);

    void buy(UUID id);
}
