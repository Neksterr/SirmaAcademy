package com.sirma.footballMatches.model.dto;

import java.time.LocalDate;

public class MatchDTO {
    private Long id;
    private Long teamAId;
    private Long teamBId;
    private LocalDate date;
    private String score;

    public MatchDTO(Long id, Long teamAId, Long teamBId, LocalDate date, String score) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
