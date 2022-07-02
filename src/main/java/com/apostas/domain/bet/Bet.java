package com.apostas.domain.bet;

import com.apostas.application.dto.BetDto;
import com.apostas.domain.game.Game;
import com.apostas.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean win;

    private String moneyBet;

    private LocalDate created_at = LocalDate.now();

    private LocalDate updated_at;

    private LocalDate terminoAposta;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "game_betlist",
            joinColumns = @JoinColumn(name = "betlist_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private List<Game> games;

    private List<GameResult> gameResult;

    public Bet() {

    }

    public Bet(Long id, List<Game> games, User user, boolean win, LocalDate created_at, LocalDate updated_at, LocalDate terminoAposta, List<GameResult> gameResult) {
        this.id = id;
        this.games = games;
        this.user = user;
        this.win = win;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.terminoAposta = terminoAposta;
        this.gameResult = gameResult;
    }

    public Bet(BetDto betDto) {
        this.id = betDto.getId();
        this.win = betDto.isWin();
        this.user = new User(betDto.getIdUser());
        this.moneyBet = betDto.getBetValue();
        this.games = betDto.getGames().stream().map(Game::new).collect(Collectors.toList());
        this.created_at = betDto.getCreated_at();
        this.updated_at = betDto.getUpdated_at();
        this.terminoAposta = betDto.getTerminoAposta();
        this.gameResult = betDto.getGameResult();
    }

    public void updateBet(BetDto betDto) {
        this.id = betDto.getId();
        this.games = betDto.getGames().stream().map(Game::new).collect(Collectors.toList());
        this.user = new User(betDto.getIdUser());
        this.user = new User(betDto.getId());
        this.win = betDto.isWin();
        this.created_at = betDto.getCreated_at();
        this.updated_at = betDto.getUpdated_at();
        this.terminoAposta = betDto.getTerminoAposta();
        this.gameResult = betDto.getGameResult();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
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

    public LocalDate getTerminoAposta() {
        return terminoAposta;
    }

    public void setTerminoAposta(LocalDate terminoAposta) {
        this.terminoAposta = terminoAposta;
    }

    public List<Game> getGames() {
        if(this.games == null) {
            this.games = new ArrayList<>();
        }
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getMoneyBet() {
        return moneyBet;
    }

    public void setMoneyBet(String moneyBet) {
        this.moneyBet = moneyBet;
    }

    public List<GameResult> getGameResult() {
        return gameResult;
    }

    public void setGameResult(List<GameResult> gameResult) {
        this.gameResult = gameResult;
    }

    
}