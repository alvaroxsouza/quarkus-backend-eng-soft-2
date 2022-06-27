package com.apostas.application.representation;

import com.apostas.domain.game.Team;

import java.io.Serializable;

public class TeamRepresentation implements Serializable {

    private Long id;
    private String nomeTeam;
    private String paisDeOrigem;

    public TeamRepresentation() {
    }

    public TeamRepresentation(Team time) {
        this.id = time.getId();
        this.nomeTeam = time.getNomeTeam();
        this.paisDeOrigem = time.getPaisDeOrigem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTeam() {
        return nomeTeam;
    }

    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }
}
