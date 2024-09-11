package com.sirma.footballMatches.model.dto;

import java.util.List;

public class TeamDTO {
    private Long id;
    private String name;
    private String manager;
    private String group;
    private List<PlayerInTeamDTO> players;

    public TeamDTO(Long id, String name, String manager, String group, List<PlayerInTeamDTO> players) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.group = group;
        this.players = players;
    }
    public TeamDTO(Long id, String name, String manager, String group) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.group = group;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<PlayerInTeamDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerInTeamDTO> players) {
        this.players = players;
    }
}
