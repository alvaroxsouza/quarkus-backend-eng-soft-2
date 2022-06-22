package com.apostas.application.dto;

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
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at;
    private LocalDate limiteAposta;
    private LocalDate dataTermino;

    public GameDto() {
    }

    public GameDto(Long id, Long idTeamHome, Long idTeamAway, ResultEnum resultBet, double oddTeamHome, double oddTeamAway, double oddTie, String campeonato, LocalDate created_at, LocalDate updated_at, LocalDate limiteAposta, LocalDate dataTermino) {
        this.id = id;
        this.idTeamHome = idTeamHome;
        this.idTeamAway = idTeamAway;
        this.resultBet = resultBet;
        this.oddTeamHome = oddTeamHome;
        this.oddTeamAway = oddTeamAway;
        this.oddTie = oddTie;
        this.campeonato = campeonato;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.limiteAposta = limiteAposta;
        this.dataTermino = dataTermino;
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

    public LocalDate getLimiteAposta() {
        return limiteAposta;
    }

    public void setLimiteAposta(LocalDate limiteAposta) {
        this.limiteAposta = limiteAposta;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDto entity = (GameDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.oddTeamHome, entity.oddTeamHome) &&
                Objects.equals(this.idTeamAway, entity.idTeamAway) &&
                Objects.equals(this.resultBet, entity.resultBet) &&
                Objects.equals(this.oddTeamHome, entity.oddTeamHome) &&
                Objects.equals(this.oddTeamAway, entity.oddTeamAway) &&
                Objects.equals(this.oddTie, entity.oddTie) &&
                Objects.equals(this.campeonato, entity.campeonato) &&
                Objects.equals(this.created_at, entity.created_at) &&
                Objects.equals(this.updated_at, entity.updated_at) &&
                Objects.equals(this.limiteAposta, entity.limiteAposta) &&
                Objects.equals(this.dataTermino, entity.dataTermino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTeamHome, idTeamAway, resultBet, oddTeamHome, oddTeamAway, oddTie, campeonato, created_at, updated_at, limiteAposta, dataTermino);
    }
}
