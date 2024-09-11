package com.sirma.footballMatches.service.impl;

import com.sirma.footballMatches.model.dto.PlayerInTeamDTO;
import com.sirma.footballMatches.model.dto.TeamDTO;
import com.sirma.footballMatches.model.entity.Team;
import com.sirma.footballMatches.repository.TeamRepository;
import com.sirma.footballMatches.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public List<TeamDTO> getAll() {
        return teamRepository.findAll().stream().map(TeamServiceImpl::map).collect(Collectors.toList());
    }

    @Override
    public Optional<Team> getTeamById(Long teamId) {
        return teamRepository.findById(teamId);
    }

    private static TeamDTO map(Team team){
       List<PlayerInTeamDTO> playerInTeamDTOS = team.getPlayers().stream().map(player -> new PlayerInTeamDTO(
               player.getId(),
               player.getFullName(),
               player.getTeamNumber(),
               player.getPosition()
       )).collect(Collectors.toList());
       return new TeamDTO(
               team.getId(),
               team.getName(),
               team.getManagerFullName(),
               team.getGroup(),
               playerInTeamDTOS
       );
    }

    public void saveTeams(List<Team> teams) {
        teamRepository.saveAll(teams);
    }
}
