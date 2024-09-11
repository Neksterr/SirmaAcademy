package com.sirma.footballMatches.service.impl;

import com.sirma.footballMatches.model.dto.PlayerDTO;
import com.sirma.footballMatches.model.entity.Player;
import com.sirma.footballMatches.repository.PlayerRepository;
import com.sirma.footballMatches.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(PlayerServiceImpl::map).collect(Collectors.toList());
    }

    @Override
    public void savePlayers(List<Player> players) {
        playerRepository.saveAll(players);
    }

    @Override
    public Optional<Player> findPlayerById(long playerId) {
        return playerRepository.findById(playerId);
    }


    private static PlayerDTO map(Player player){

        return new PlayerDTO(
                player.getId(),
                player.getFullName(),
                player.getTeamNumber(),
                player.getPosition(),
                player.getTeam().getId()
        );
    }
}
