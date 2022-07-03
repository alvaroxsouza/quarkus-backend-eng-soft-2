package com.apostas.application.dto;

import com.apostas.domain.enumutilities.ResultEnum;

import java.io.Serializable;
import java.util.Objects;

public class GameResultDto implements Serializable {

    private Long idGame;
    private String resultBet;

    public GameResultDto() {
    }

    public GameResultDto(Long idGame, String resultBet) {
        this.idGame = idGame;
        this.resultBet = resultBet;
    }

    public Long getIdGame() {
        return idGame;
    }

    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public String getResultBet() {
        return resultBet;
    }

    public void setResultBet(String resultBet) {
        this.resultBet = resultBet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResultDto entity = (GameResultDto) o;
        return Objects.equals(this.resultBet, entity.resultBet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultBet);
    }
}
