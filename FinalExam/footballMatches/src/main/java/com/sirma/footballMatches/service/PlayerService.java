package com.sirma.footballMatches.service;

import com.sirma.footballMatches.model.dto.PlayerDTO;
import com.sirma.footballMatches.model.entity.Player;

import java.util.List;
import java.util.Optional;


public interface PlayerService {

    public List<PlayerDTO> getAllPlayers();

    public void savePlayers(List<Player> players);

    public Optional<Player> findPlayerById(long playerId);
}
