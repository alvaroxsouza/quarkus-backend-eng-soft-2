package com.apostas.domain.aposta;

import com.apostas.domain.enumutilities.ResultEnum;

public class GameResult {
    private Long game;
    private ResultEnum result;

    public GameResult(Long game, ResultEnum result) {
        this.game = game;
        this.result = result;
    }
    public Long getGame() {
        return game;
    }
    public void setGame(Long game) {
        this.game = game;
    }
    public ResultEnum getResult() {
        return result;
    }
    public void setResult(ResultEnum result) {
        this.result = result;
    }
    
}
