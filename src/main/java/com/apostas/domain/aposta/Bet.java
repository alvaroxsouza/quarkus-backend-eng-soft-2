package com.apostas.domain.aposta;

import com.apostas.application.dto.BetDto;
import com.apostas.domain.game.rival.Game;
import com.apostas.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    private List<Game> games;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean win;

    private LocalDate created_at = LocalDate.now();

    private LocalDate updated_at;

    private LocalDate terminoAposta;

    public Bet() {

    }

    public Bet(Long id, List<Game> games, User user, boolean win, LocalDate created_at, LocalDate updated_at, LocalDate terminoAposta) {
        this.id = id;
        this.games = games;
        this.user = user;
        this.win = win;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.terminoAposta = terminoAposta;
    }

    public Bet(BetDto betDto) {
        this.id = betDto.getId();
        this.games = betDto.getGames().stream().map(Game::new).collect(Collectors.toList());
        this.user = new User(betDto.getUser());
        this.win = betDto.getWin();
        this.created_at = betDto.getCreated_at();
        this.updated_at = betDto.getUpdated_at();
        this.terminoAposta = betDto.getTerminoAposta();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
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

    public void updateBet(BetDto betDto) {
        this.id = betDto.getId();
        this.games = betDto.getGames().stream().map(Game::new).collect(Collectors.toList());
        this.user = new User(betDto.getUser());
        this.win = betDto.getWin();
        this.created_at = betDto.getCreated_at();
        this.updated_at = betDto.getUpdated_at();
        this.terminoAposta = betDto.getTerminoAposta();
    }
}