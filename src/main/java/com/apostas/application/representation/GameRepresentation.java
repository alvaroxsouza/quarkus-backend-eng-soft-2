package com.apostas.application.representation;

import com.apostas.domain.enumutilities.CategoryEnum;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.Game;

import java.io.Serializable;
import java.time.LocalDate;

public class GameRepresentation implements Serializable {

    private Long id;
    private TeamRepresentation teamHome;
    private TeamRepresentation teamAway;
    private ResultEnum resultBet;
    private double oddTeamHome;
    private double oddTeamAway;
    private double oddTie;
    private String campeonato;
    private CategoryEnum cateryEnum;
    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate limiteAposta;
    private LocalDate dataTermino;

    public GameRepresentation() {
    }

    public GameRepresentation(Game game) {
        this.id = game.getId();
        this.teamHome = new TeamRepresentation(game.getTeamHome());
        this.teamAway = new TeamRepresentation(game.getTeamAway());
        this.resultBet = game.getResultBet();
        this.oddTeamHome = game.getOddTeamHome();
        this.oddTeamAway = game.getOddTeamAway();
        this.oddTie = game.getOddTie();
        this.cateryEnum = game.getCategory();
        this.campeonato = game.getCampeonato();
        this.created_at = game.getCreated_at();
        this.updated_at = game.getUpdated_at();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamRepresentation getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(TeamRepresentation teamHome) {
        this.teamHome = teamHome;
    }

    public TeamRepresentation getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(TeamRepresentation teamAway) {
        this.teamAway = teamAway;
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
}
