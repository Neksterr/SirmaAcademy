package com.sirma.footballMatches.controller;


import com.sirma.footballMatches.model.dto.MatchDTO;
import com.sirma.footballMatches.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @GetMapping
    public List<MatchDTO> getAllMatches(){
        return matchService.getAll();
    }
}
