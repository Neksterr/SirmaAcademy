package com.sirma.footballMatches.service.impl;

import com.sirma.footballMatches.model.dto.MatchDTO;
import com.sirma.footballMatches.model.entity.Match;
import com.sirma.footballMatches.model.entity.Player;
import com.sirma.footballMatches.repository.MatchRepository;
import com.sirma.footballMatches.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl  implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchDTO> getAll() {
        return matchRepository.findAll().stream().map(MatchServiceImpl::map).collect(Collectors.toList());
    }

    @Override
    public Optional<Match> findPlayerById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    private static MatchDTO map(Match match){

        return new MatchDTO(
                match.getId(),
                match.getTeamA().getId(),
                match.getTeamB().getId(),
                match.getDate(),
                match.getScore()
        );
    }
    public void savePlayersMatches(List<Match> matches){
        matchRepository.saveAll(matches);
    }
}
