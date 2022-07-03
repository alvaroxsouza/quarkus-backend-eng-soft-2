package com.apostas.application.dto;

import com.apostas.domain.enumutilities.CategoryEnum;
import com.apostas.domain.enumutilities.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class GameDto implements Serializable {
    @JsonIgnore
    private Long id;
    private Long idTeamHome;
    private Long idTeamAway;
    private ResultEnum resultBet;
    private double oddTeamHome;
    private double oddTeamAway;
    private double oddTie;
    private String campeonato;
    private CategoryEnum category;
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at;
    private boolean terminou;
    private Integer pontuacaoTimeHome;
    private Integer pontuacaoTimeAway;

    public GameDto() {
    }

    public GameDto(Long id, Long idTeamHome, Long idTeamAway, ResultEnum resultBet, double oddTeamHome, double oddTeamAway, double oddTie, String campeonato, CategoryEnum category, LocalDate created_at, LocalDate updated_at, boolean terminou, Integer pontuacaoTimeHome, Integer pontuacaoTimeAway) {
        this.id = id;
        this.idTeamHome = idTeamHome;
        this.idTeamAway = idTeamAway;
        this.resultBet = resultBet;
        this.oddTeamHome = oddTeamHome;
        this.oddTeamAway = oddTeamAway;
        this.oddTie = oddTie;
        this.campeonato = campeonato;
        this.category = category;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public Long getIdTeamHome() {
        return idTeamHome;
    }

    public void setIdTeamHome(Long idTeamHome) {
        this.idTeamHome = idTeamHome;
    }

    public Long getIdTeamAway() {
        return idTeamAway;
    }

    public void setIdTeamAway(Long idTeamAway) {
        this.idTeamAway = idTeamAway;
    }

    public ResultEnum getResultBet() {
        return resultBet;
    }

    public void setResultBet(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }

    public double getOddTeamHome() {
        return oddTeamHome;
    }

    public void setOddTeamHome(double oddTeamHome) {
        this.oddTeamHome = oddTeamHome;
    }

    public double getOddTeamAway() {
        return oddTeamAway;
    }

    public void setOddTeamAway(double oddTeamAway) {
        this.oddTeamAway = oddTeamAway;
    }

    public double getOddTie() {
        return oddTie;
    }

    public void setOddTie(double oddTie) {
        this.oddTie = oddTie;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isTerminou() {
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
        GameDto entity = (GameDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.resultBet, entity.resultBet) &&
                Objects.equals(this.oddTeamHome, entity.oddTeamHome) &&
                Objects.equals(this.oddTeamAway, entity.oddTeamAway) &&
                Objects.equals(this.oddTie, entity.oddTie) &&
                Objects.equals(this.campeonato, entity.campeonato) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.created_at, entity.created_at) &&
                Objects.equals(this.updated_at, entity.updated_at) &&
                Objects.equals(this.terminou, entity.terminou) &&
                Objects.equals(this.pontuacaoTimeHome, entity.pontuacaoTimeHome) &&
                Objects.equals(this.pontuacaoTimeAway, entity.pontuacaoTimeAway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resultBet, oddTeamHome, oddTeamAway, oddTie, campeonato, category, created_at, updated_at, terminou, pontuacaoTimeHome, pontuacaoTimeAway);
    }
}
