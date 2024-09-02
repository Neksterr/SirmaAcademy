package com.softuni.resellerApp.controller;

import com.softuni.resellerApp.model.OfferCreateBindingModel;
import com.softuni.resellerApp.service.OfferService;
import jakarta.persistence.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("offer-add");
    }

    @PostMapping("/create")
    public ModelAndView create(OfferCreateBindingModel offerCreateBindingModel) {
        boolean isCreated = offerService.create(offerCreateBindingModel);
        String view = isCreated ? "redirect:/home" : "create";
        return new ModelAndView(view);
    }

    @PostMapping("/buy/{id}")
    public ModelAndView buyOffer(@PathVariable("id") UUID id) {
        offerService.buy(id);
        return new ModelAndView("redirect:/home");
    }
}
