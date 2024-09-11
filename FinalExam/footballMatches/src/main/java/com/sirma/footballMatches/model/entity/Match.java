package com.sirma.footballMatches.model.entity;


import com.sirma.footballMatches.model.dto.TeamDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Team teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;
    private LocalDate date;
    private String score;

    public Match(Team teamA, Team teamB, LocalDate date, String score) {

        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.score = score;
    }
    public Match(){

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
