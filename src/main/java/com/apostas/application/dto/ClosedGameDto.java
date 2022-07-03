package com.apostas.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class ClosedGameDto implements Serializable {
    @JsonIgnore
    private Long id;
    private boolean terminou;
    private Integer pontuacaoTimeHome;
    private Integer pontuacaoTimeAway;

    public ClosedGameDto() {
    }

    public ClosedGameDto(Long id, boolean terminou, Integer pontuacaoTimeHome, Integer pontuacaoTimeAway) {
        this.id = id;
        this.terminou = terminou;
        this.pontuacaoTimeHome = pontuacaoTimeHome;
        this.pontuacaoTimeAway = pontuacaoTimeAway;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    public Integer getPontuacaoTimeHome() {
        return pontuacaoTimeHome;
    }

    public void setPontuacaoTimeHome(Integer pontuacaoTimeHome) {
        this.pontuacaoTimeHome = pontuacaoTimeHome;
    }

    public Integer getPontuacaoTimeAway() {
        return pontuacaoTimeAway;
    }

    public void setPontuacaoTimeAway(Integer pontuacaoTimeAway) {
        this.pontuacaoTimeAway = pontuacaoTimeAway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClosedGameDto entity = (ClosedGameDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.terminou, entity.terminou) &&
                Objects.equals(this.pontuacaoTimeHome, entity.pontuacaoTimeHome) &&
                Objects.equals(this.pontuacaoTimeAway, entity.pontuacaoTimeAway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, terminou, pontuacaoTimeHome, pontuacaoTimeAway);
    }
}
