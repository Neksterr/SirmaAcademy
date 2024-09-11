package com.sirma.footballMatches.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "records")
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @Positive
    private int fromMinutes;
    @Positive
    private int toMinutes;

    public Records(Player player, Match match, int fromMinutes, int toMinutes) {
        this.player = player;
        this.match = match;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }
    public Records(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public int getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(int toMinutes) {
        this.toMinutes = toMinutes;
    }
}
