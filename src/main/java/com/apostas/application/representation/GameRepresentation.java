package com.apostas.application.representation;

import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.rival.Game;

import java.io.Serializable;
import java.time.LocalDate;

public class GameRepresentation implements Serializable {

    private Long id;
    private RivalRepresentation rivalHome;
    private RivalRepresentation rivalAway;
    private ResultEnum resultBet;
    private double oddRivalHome;
    private double oddRivalAway;
    private double oddTie;
    private String campeonato;
    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate limiteAposta;
    private LocalDate dataTermino;

    public GameRepresentation() {
    }

    public GameRepresentation(Game game) {
        this.id = game.getId();
        this.rivalHome = new RivalRepresentation(game.getRivalHome());
        this.rivalAway = new RivalRepresentation(game.getRivalAway());
        this.resultBet = game.getResultBet();
        this.oddRivalHome = game.getOddRivalHome();
        this.oddRivalAway = game.getOddRivalAway();
        this.oddTie = game.getOddTie();
        this.campeonato = game.getCampeonato();
        this.created_at = game.getCreated_at();
        this.updated_at = game.getUpdated_at();
        this.limiteAposta = game.getLimiteAposta();
        this.dataTermino = game.getDataTermino();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RivalRepresentation getRivalHome() {
        return rivalHome;
    }

    public void setRivalHome(RivalRepresentation rivalHome) {
        this.rivalHome = rivalHome;
    }

    public RivalRepresentation getRivalAway() {
        return rivalAway;
    }

    public void setRivalAway(RivalRepresentation rivalAway) {
        this.rivalAway = rivalAway;
    }

    public ResultEnum getResultBet() {
        return resultBet;
    }

    public void setResultBet(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }

    public double getOddRivalHome() {
        return oddRivalHome;
    }

    public void setOddRivalHome(double oddRivalHome) {
        this.oddRivalHome = oddRivalHome;
    }

    public double getOddRivalAway() {
        return oddRivalAway;
    }

    public void setOddRivalAway(double oddRivalAway) {
        this.oddRivalAway = oddRivalAway;
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
