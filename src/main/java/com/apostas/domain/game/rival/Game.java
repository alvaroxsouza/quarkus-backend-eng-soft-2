package com.apostas.domain.game.rival;

import com.apostas.application.dto.GameDto;
import com.apostas.domain.aposta.Bet;
import com.apostas.domain.enumutilities.ResultEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rival_home_id", referencedColumnName = "id")
    private Rival rivalHome;

    @ManyToOne
    @JoinColumn(name = "rival_away_id", referencedColumnName = "id")
    private Rival rivalAway;

    @Enumerated(EnumType.STRING)
    private ResultEnum resultBet;

    private double oddRivalHome;

    private double oddRivalAway;

    private double oddTie;

    private String campeonato;

    private LocalDate created_at = LocalDate.now();

    private LocalDate updated_at;

    private LocalDate limiteAposta;

    private LocalDate dataTermino;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "game_betList",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "betlist_id"))
    private List<Bet> bets;


    public Game() {
    }

    public Game(Long id, Rival rivalHome, Rival rivalAway, ResultEnum resultBet, double oddRivalHome, double oddRivalAway, double oddTie, String campeonato, LocalDate created_at, LocalDate updated_at, LocalDate limiteAposta, LocalDate dataTermino) {
        this.id = id;
        this.rivalHome = rivalHome;
        this.rivalAway = rivalAway;
        this.resultBet = resultBet;
        this.oddRivalHome = oddRivalHome;
        this.oddRivalAway = oddRivalAway;
        this.oddTie = oddTie;
        this.campeonato = campeonato;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.limiteAposta = limiteAposta;
        this.dataTermino = dataTermino;
    }

    public Game(GameDto gameDto) {
        this.id = gameDto.getId();
        this.rivalHome = new Rival(gameDto.getIdRivalHome());
        this.rivalAway = new Rival(gameDto.getIdRivalAway());
        this.resultBet = gameDto.getResultBet();
        this.oddRivalHome = gameDto.getOddRivalHome();
        this.oddRivalAway = gameDto.getOddRivalAway();
        this.oddTie = gameDto.getOddTie();
        this.campeonato = gameDto.getCampeonato();
        this.created_at = gameDto.getCreated_at();
        this.updated_at = gameDto.getUpdated_at();
        this.limiteAposta = gameDto.getLimiteAposta();
        this.dataTermino = gameDto.getDataTermino();
    }

    public Game(Long idGame) {
        this.id = idGame;
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

    public ResultEnum getResultBet() {
        return resultBet;
    }

    public void setResultBet(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }

    public double getOddRivalHome() {
        return oddRivalHome;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
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

    public void updateGame(GameDto gameDto) {
        this.id = gameDto.getId();
        this.rivalAway = new Rival(gameDto.getIdRivalAway());
        this.rivalHome = new Rival(gameDto.getIdRivalHome());
        this.resultBet = gameDto.getResultBet();
        this.oddRivalHome = gameDto.getOddRivalHome();
        this.oddRivalAway = gameDto.getOddRivalAway();
        this.oddTie = gameDto.getOddTie();
        this.campeonato = gameDto.getCampeonato();
        this.updated_at = LocalDate.now();
        this.limiteAposta = gameDto.getLimiteAposta();
        this.dataTermino = gameDto.getDataTermino();
    }
}