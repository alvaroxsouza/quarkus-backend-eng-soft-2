package com.apostas.application.representation;

import com.apostas.domain.game.rival.Rival;

import java.io.Serializable;

public class RivalRepresentation implements Serializable {

    private Long id;
    private String nomeRival;
    private String paisDeOrigem;

    public RivalRepresentation() {
    }

    public RivalRepresentation(Rival rival) {
        this.id = rival.getId();
        this.nomeRival = rival.getNomeRival();
        this.paisDeOrigem = rival.getPaisDeOrigem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRival() {
        return nomeRival;
    }

    public void setNomeRival(String nomeRival) {
        this.nomeRival = nomeRival;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }
}
