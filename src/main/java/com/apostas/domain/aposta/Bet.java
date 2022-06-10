package com.apostas.domain.aposta;

import com.apostas.domain.game.rival.Game;
import com.apostas.domain.user.User;

import javax.persistence.*;
import java.util.List;

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

    public Bet() {

    }

    public Bet(List<Game> games, User user, boolean win) {
        this.games = games;
        this.user = user;
        this.win = win;
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
}