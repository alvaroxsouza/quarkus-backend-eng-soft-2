package com.apostas.domain.game;

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
    @JoinColumn(name = "team_home_id", referencedColumnName = "id")
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id", referencedColumnName = "id")
    private Team teamAway;

    @Enumerated(EnumType.STRING)
    private ResultEnum resultBet;

    private double oddTeamHome;

    private double oddTeamAway;

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

    public Game(Long id) {
        this.id = id;
    }

    public Game(Long id, Team teamHome, Team teamAway, ResultEnum resultBet, double oddRivalHome, double oddRivalAway, double oddTie, String campeonato, LocalDate created_at, LocalDate updated_at, LocalDate limiteAposta, LocalDate dataTermino) {
        this.id = id;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.resultBet = resultBet;
        this.oddTeamHome = oddRivalHome;
        this.oddTeamAway = oddRivalAway;
        this.oddTie = oddTie;
        this.campeonato = campeonato;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.limiteAposta = limiteAposta;
        this.dataTermino = dataTermino;
    }

    public Game(GameDto gameDto) {
        this.id = gameDto.getId();
        this.teamHome = new Team(gameDto.getIdTeamHome());
        this.teamAway = new Team(gameDto.getIdTeamAway());
        this.resultBet = gameDto.getResultBet();
        this.oddTeamHome = gameDto.getOddTeamHome();
        this.oddTeamAway = gameDto.getOddTeamAway();
        this.oddTie = gameDto.getOddTie();
        this.campeonato = gameDto.getCampeonato();
        this.created_at = gameDto.getCreated_at();
        this.updated_at = gameDto.getUpdated_at();
        this.limiteAposta = gameDto.getLimiteAposta();
        this.dataTermino = gameDto.getDataTermino();
    }

    public void updateGame(GameDto gameDto) {
        this.id = gameDto.getId();
        this.teamAway = new Team(gameDto.getIdTeamAway());
        this.teamHome = new Team(gameDto.getIdTeamHome());
        this.resultBet = gameDto.getResultBet();
        this.oddTeamHome = gameDto.getOddTeamHome();
        this.oddTeamAway = gameDto.getOddTeamAway();
        this.oddTie = gameDto.getOddTie();
        this.campeonato = gameDto.getCampeonato();
        this.updated_at = LocalDate.now();
        this.limiteAposta = gameDto.getLimiteAposta();
        this.dataTermino = gameDto.getDataTermino();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public ResultEnum getResultBet() {
        return resultBet;
    }

    public void setResultBet(ResultEnum resultBet) {
        this.resultBet = resultBet;
    }

    public double getOddTeamHome() {
        return oddTeamHome;
    }

    public void setOddTeamHome(double oddTeamHome) {
        this.oddTeamHome = oddTeamHome;
    }

    public double getOddTeamAway() {
        return oddTeamAway;
    }

    public void setOddTeamAway(double oddTeamAway) {
        this.oddTeamAway = oddTeamAway;
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

    public List<Bet> getBets() {
        return (bets != null) ? bets : new ArrayList<>();
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}