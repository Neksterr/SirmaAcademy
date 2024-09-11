package com.sirma.footballMatches.util;

import com.sirma.footballMatches.model.dto.TeamDTO;
import com.sirma.footballMatches.model.entity.Match;
import com.sirma.footballMatches.model.entity.Player;
import com.sirma.footballMatches.model.entity.Records;
import com.sirma.footballMatches.model.entity.Team;
import com.sirma.footballMatches.service.TeamService;
import com.sirma.footballMatches.service.impl.MatchServiceImpl;
import com.sirma.footballMatches.service.impl.PlayerServiceImpl;
import com.sirma.footballMatches.service.impl.RecordServiceImpl;
import com.sirma.footballMatches.service.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private PlayerServiceImpl playerService;
    @Autowired
    private MatchServiceImpl matchService;
    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private CSVReader csvReader;

    public void start(){
        loadData();
    }

    private void loadData() {
        String filePath = "src\\main\\java\\com\\sirma\\footballMatches\\util";
        List<Player> players = csvReader.readPlayers(filePath + "/players.csv");
        if(players!=null){
            playerService.savePlayers(players);
        }
        List<Team> teams = csvReader.readTeams(filePath + "/teams.csv");
        if(teams!=null){
            teamService.saveTeams(teams);
        }
        List<Match> matches = csvReader.readMatches(filePath + "/matches.csv");
        if(matches!=null){
            matchService.savePlayersMatches(matches);
        }
        List<Records> records = csvReader.readRecords(filePath + "/records.csv");
        if(records!=null){
            recordService.saveAllRecords(records);
        }
    }
}
