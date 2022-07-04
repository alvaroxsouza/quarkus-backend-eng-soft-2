package com.apostas.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class TeamDto implements Serializable {
    @JsonIgnore
    private Long id;
    private String nomeTeam;
    private String paisDeOrigem;

    public TeamDto() {
    }

    public TeamDto(Long id, String nomeTeam, String paisDeOrigem) {
        this.id = id;
        this.nomeTeam = nomeTeam;
        this.paisDeOrigem = paisDeOrigem;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamDto entity = (TeamDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nomeTeam, entity.nomeTeam) &&
                Objects.equals(this.paisDeOrigem, entity.paisDeOrigem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeTeam, paisDeOrigem);
    }
}
