package com.sirma.footballMatches.service;

import com.sirma.footballMatches.model.dto.TeamDTO;
import com.sirma.footballMatches.model.entity.Team;

import java.util.List;
import java.util.Optional;


public interface TeamService {


   List<TeamDTO> getAll();

    Optional<Team> getTeamById(Long teamId);
}
