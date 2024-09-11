package com.sirma.footballMatches.service;

import com.sirma.footballMatches.model.dto.MatchDTO;
import com.sirma.footballMatches.model.entity.Match;

import java.util.List;
import java.util.Optional;


public interface MatchService {

    public List<MatchDTO> getAll() ;

    public Optional<Match> findPlayerById(Long matchId);
}
