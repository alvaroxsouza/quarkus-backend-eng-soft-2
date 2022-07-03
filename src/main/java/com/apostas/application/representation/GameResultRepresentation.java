package com.apostas.application.representation;

import com.apostas.domain.bet.Bet;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.Game;

import javax.persistence.*;

public class GameResultRepresentation {
    private Long id;
    private GameRepresentation game;
    private BetRepresentation bet;
    private ResultEnum resultBet;

    public GameResultRepresentation() {

    }

    public GameResultRepresentation(BetRepresentation bet, GameRepresentation game, ResultEnum result) {
        this.game = game;
        this.resultBet = result;
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameRepresentation getGame() {
        return game;
    }

    public void setGame(GameRepresentation game) {
        this.game = game;
    }

    public BetRepresentation getBet() {
        return bet;
    }

    public void setBet(BetRepresentation bet) {
        this.bet = bet;
    }

    public ResultEnum getResultBet() {
        return resultBet;
    }

    public void setResultBet(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }
}
