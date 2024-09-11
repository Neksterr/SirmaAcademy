package com.sirma.footballMatches.model.dto;

public class PlayerPairTime {
    private final PairDTO playerPair;
    private final long totalTimeTogether;

    public PlayerPairTime(PairDTO playerPair, long totalTimeTogether) {
        this.playerPair = playerPair;
        this.totalTimeTogether = totalTimeTogether;
    }

    public PairDTO getPlayerPair() {
        return playerPair;
    }

    public long getTotalTimeTogether() {
        return totalTimeTogether;
    }
}
