package com.apostas.domain.game.rival;

import com.apostas.domain.aposta.Bet;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rival_home_id")
    private Rival rivalHome;

    @ManyToOne
    @JoinColumn(name = "rival_away_id")
    private Rival rivalAway;

    @ManyToMany
    @JoinColumn(name = "bet_id")
    private List<Bet> bet;

    public Game() {
    }

    public Game(Long id, Rival rivalHome, Rival rivalAway, List<Bet> bet) {
        this.id = id;
        this.rivalHome = rivalHome;
        this.rivalAway = rivalAway;
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rival getRivalHome() {
        return rivalHome;
    }

    public void setRivalHome(Rival rivalHome) {
        this.rivalHome = rivalHome;
    }

    public Rival getRivalAway() {
        return rivalAway;
    }

    public void setRivalAway(Rival rivalAway) {
        this.rivalAway = rivalAway;
    }

    public List<Bet> getBet() {
        return bet;
    }

    public void setBet(List<Bet> bet) {
        this.bet = bet;
    }
}