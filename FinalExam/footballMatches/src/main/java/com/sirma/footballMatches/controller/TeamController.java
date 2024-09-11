package com.sirma.footballMatches.controller;


import com.sirma.footballMatches.model.dto.TeamDTO;
import com.sirma.footballMatches.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public List<TeamDTO> getAllTeams(){
        return  teamService.getAll();
    }
}
