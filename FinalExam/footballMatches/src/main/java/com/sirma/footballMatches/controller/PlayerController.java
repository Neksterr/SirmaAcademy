package com.sirma.footballMatches.controller;


import com.sirma.footballMatches.model.dto.PlayerDTO;
import com.sirma.footballMatches.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public List<PlayerDTO> getAllPlayers(){
        return playerService.getAllPlayers();
    }
}
