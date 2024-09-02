package com.softuni.resellerApp.controller;

import com.softuni.resellerApp.model.OfferHomeDTO;
import com.softuni.resellerApp.service.OfferService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        OfferHomeDTO offersForHomePage =  offerService.getOffersForHomePage();
        modelAndView.addObject("offerHomeDTO", offersForHomePage);
        return modelAndView;
    }
}
