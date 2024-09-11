package com.sirma.footballMatches.util;

import com.sirma.footballMatches.model.entity.Match;
import com.sirma.footballMatches.model.entity.Player;
import com.sirma.footballMatches.model.entity.Records;
import com.sirma.footballMatches.model.entity.Team;
import com.sirma.footballMatches.service.MatchService;
import com.sirma.footballMatches.service.PlayerService;
import com.sirma.footballMatches.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import  java.io.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CSVReader {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;

    

    public List<Player> readPlayers(String filePath){
        List<Player> players = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNum = 0;
            if((line = bufferedReader.readLine()) == null){
                System.out.println("Empty file");
                return players;
            }
            
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                
                int teamNumber = Integer.parseInt(data[1]);
                String position = data[2];
                String name = data[3];
                Long teamId = Long.parseLong(data[4]);
                Team team = teamService.getTeamById(teamId).get();
                Player player = new Player(name, teamNumber,position,team);
                players.add(player);
                lineNum++;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return players;
    }


    public List<Team> readTeams(String filePath){
        List<Team> teams = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNum = 0;
            if((line = bufferedReader.readLine()) == null){
                System.out.println("Empty file");
                return teams;
            }

            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                String country = data[1];
                String manager = data[2];
                String group = data[3];

                Team team = new Team(country, manager,group);
                teams.add(team);
                lineNum++;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return teams;
    }
    public List<Match> readMatches(String filePath){
        List<Match> matches = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNum = 0;
            if((line = bufferedReader.readLine()) == null){
                System.out.println("Empty file");
                return matches;
            }

            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                long teamAId = Long.parseLong(data[1]);
                long teamBId = Long.parseLong(data[2]);
                Team teamA = teamService.getTeamById(teamAId).get();
                Team teamB = teamService.getTeamById(teamBId).get();
                LocalDate date = LocalDate.parse(data[3]);
                String result = data[4];
                Match match = new Match(teamA, teamB,date,result);
                matches.add(match);
                lineNum++;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return matches;
    }
    public List<Records> readRecords(String filePath){
        List<Records> records = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNum = 0;
            if((line = bufferedReader.readLine()) == null){
                System.out.println("Empty file");
                return records;
            }

            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                long playerId = Long.parseLong(data[1]);

                Player player = playerService.findPlayerById(playerId).get();
                Long matchId = Long.parseLong(data[2]);
                Match match = matchService.findPlayerById(matchId).get();
                int fromMinutes = Integer.parseInt(data[3]);
                int toMinutes;

                if(data[4].equals("NULL")){
                    toMinutes = 90;
                } else  {
                    toMinutes = Integer.parseInt((data[4]));
                }
                Records recordsMatches = new Records(player,match,fromMinutes,toMinutes);
                records.add(recordsMatches);
                lineNum++;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return records;
    }

}
