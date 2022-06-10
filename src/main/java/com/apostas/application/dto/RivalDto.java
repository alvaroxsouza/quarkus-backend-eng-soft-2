package com.apostas.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RivalDto implements Serializable {
    private Long id;
    private String nomeRival;
    private String paisDeOrigem;
    private String campeonato;

    public RivalDto() {
    }

    public RivalDto(Long id, String nomeRival, String paisDeOrigem, String campeonato) {
        this.id = id;
        this.nomeRival = nomeRival;
        this.paisDeOrigem = paisDeOrigem;
        this.campeonato = campeonato;
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

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RivalDto entity = (RivalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nomeRival, entity.nomeRival) &&
                Objects.equals(this.paisDeOrigem, entity.paisDeOrigem) &&
                Objects.equals(this.campeonato, entity.campeonato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeRival, paisDeOrigem, campeonato);
    }
}
