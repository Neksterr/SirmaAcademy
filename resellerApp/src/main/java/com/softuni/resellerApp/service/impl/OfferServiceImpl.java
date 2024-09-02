package com.softuni.resellerApp.service.impl;

import com.softuni.resellerApp.model.*;
import com.softuni.resellerApp.model.entity.Condition;
import com.softuni.resellerApp.model.entity.Offer;
import com.softuni.resellerApp.model.entity.User;
import com.softuni.resellerApp.repository.ConditionRepository;
import com.softuni.resellerApp.repository.OfferRepository;
import com.softuni.resellerApp.repository.UserRepository;
import com.softuni.resellerApp.service.LoggedUser;
import com.softuni.resellerApp.service.OfferService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final LoggedUser loggedUser;
    private final ConditionRepository conditionRepository;
    private UserRepository userRepository;


    public OfferServiceImpl(OfferRepository offerRepository, LoggedUser loggedUser, Condition condition, ConditionRepository conditionRepository) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
        this.conditionRepository = conditionRepository;

    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = offerRepository.findAll();
        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();
        for (Offer offer : offers) {
            String loggedUsername = loggedUser.getUsername();
            if (offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOfferDTO(offer));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else if(offer.getBoughtBy() == null){
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        return new OfferHomeDTO(myOffers,boughtOffers,otherOffers);
    }

    @Override
    public boolean create(OfferCreateBindingModel offerCreateBindingModel) {
        Condition condition=  conditionRepository.findByName(offerCreateBindingModel.getCondition());
        User user = userRepository.findByUsername(loggedUser.getUsername());
        if(condition != null && user != null) {
            Offer offer = new Offer(offerCreateBindingModel, condition, user);
            offerRepository.save(offer);
            return  true;
        }
        return  false;
    }

    @Override
    public void buy(UUID id) {
       Optional<Offer> optionalOffer=  offerRepository.findById(id);
       if(optionalOffer.isPresent()){
           User user = userRepository.findByUsername(loggedUser.getUsername());
           Offer offer = optionalOffer.get();
           offer.setBoughtBy(user);
           offerRepository.save(offer);
       }
    }
}
