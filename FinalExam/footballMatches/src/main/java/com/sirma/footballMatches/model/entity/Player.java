package com.sirma.footballMatches.model.entity;

import com.sirma.footballMatches.model.dto.TeamDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private int teamNumber;
    @NotNull
    private String position;
    @NotNull
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

     public  Player(){

     }
    public Player(Long id, int teamNumber, String position, String fullName, Team team) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.team = team;
    }

    public Player(String name, int teamNumber, String position, Team team) {
        this.fullName = name;
        this.teamNumber = teamNumber;
        this.position = position;

        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
