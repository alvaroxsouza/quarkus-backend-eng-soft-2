package com.apostas.domain.bet;

import com.apostas.application.dto.GameResultDto;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.Game;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "bet_game_result")
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bet_id")
    private Bet bet;

    @Enumerated(EnumType.STRING)
    private ResultEnum resultBet;

    public GameResult() {

    }

    public GameResult(Long id) {
        this.id = id;
    }

    public GameResult(Bet bet, @NotNull GameResultDto gameResultDto) {
        this.game = new Game(gameResultDto.getIdGame());
        this.bet = bet;
        this.resultBet = ResultEnum.valueOf(gameResultDto.getResultBet());
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public ResultEnum getResult() {
        return resultBet;
    }
    public void setResult(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }
}
