package com.apostas.domain.game;

import com.apostas.application.dto.TeamDto;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomeTime;

    private String paisDeOrigem;

    public Team() {
    }

    public Team(Long id, String nomeTime, String paisDeOrigem) {
        this.id = id;
        this.nomeTime = nomeTime;
        this.paisDeOrigem = paisDeOrigem;
    }

    public Team(TeamDto teamDto) {
        this.id = teamDto.getId();
        this.nomeTime = teamDto.getNomeTeam();
        this.paisDeOrigem = teamDto.getPaisDeOrigem();
    }

    public Team(Long idTeam) {
        this.id = idTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTeam() {
        return nomeTime;
    }

    public void setNomeTeam(String nomeTeam) {
        this.nomeTime = nomeTeam;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public void updateTeam(TeamDto teamDto) {
        this.id = teamDto.getId();
        this.nomeTime = teamDto.getNomeTeam();
        this.paisDeOrigem = teamDto.getPaisDeOrigem();
    }
}
