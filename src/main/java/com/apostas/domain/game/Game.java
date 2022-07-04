package com.apostas.domain.game;

import com.apostas.application.dto.ClosedGameDto;
import com.apostas.application.dto.GameDto;
import com.apostas.domain.bet.Bet;
import com.apostas.domain.enumutilities.CategoryEnum;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @CreationTimestamp
    private LocalDate created_at = LocalDate.now();
    @CreationTimestamp
    private LocalDate updated_at;

    private boolean terminou;
    private Integer pontuacaoTimeHome;
    private Integer pontuacaoTimeAway;

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

    public Game(Long id, Team teamHome, Team teamAway, ResultEnum resultBet, double oddTeamHome, double oddTeamAway, double oddTie, String campeonato, LocalDate created_at, LocalDate updated_at, LocalDate limiteAposta) {
        this.id = id;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.resultBet = resultBet;
        this.oddTeamHome = oddTeamHome;
        this.oddTeamAway = oddTeamAway;
        this.oddTie = oddTie;
        this.campeonato = campeonato;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Game(GameDto gameDto) {
        this.id = gameDto.getId();
        this.teamHome = new Team(gameDto.getIdTeamHome());
        this.teamAway = new Team(gameDto.getIdTeamAway());
        this.resultBet = gameDto.getResultBet();
        this.oddTeamHome = gameDto.getOddTeamHome();
        this.oddTeamAway = gameDto.getOddTeamAway();
        this.oddTie = gameDto.getOddTie();
        this.category = gameDto.getCategory();
        this.campeonato = gameDto.getCampeonato();
        this.created_at = gameDto.getCreated_at();
        this.updated_at = gameDto.getUpdated_at();
    }

    public void updateGame(GameDto gameDto) {
        this.id = gameDto.getId();
        this.teamAway = new Team(gameDto.getIdTeamAway());
        this.teamHome = new Team(gameDto.getIdTeamHome());
        this.pontuacaoTimeHome = gameDto.getPontuacaoTimeHome();
        this.pontuacaoTimeAway = gameDto.getPontuacaoTimeAway();
        this.resultBet = gameDto.getResultBet();
        this.oddTeamHome = gameDto.getOddTeamHome();
        this.oddTeamAway = gameDto.getOddTeamAway();
        this.oddTie = gameDto.getOddTie();
        this.campeonato = gameDto.getCampeonato();
        this.updated_at = LocalDate.now();
    }

    public void closedGame(ClosedGameDto closedGameDto) {
        this.pontuacaoTimeHome = closedGameDto.getPontuacaoTimeHome();
        this.pontuacaoTimeAway = closedGameDto.getPontuacaoTimeAway();
        this.terminou = true;
        this.whoWon();
    }

    private void whoWon(){
        if(this.terminou){
            if(this.pontuacaoTimeHome > this.pontuacaoTimeAway)
                this.resultBet = ResultEnum.GANHADOR_CASA;
            else if(this.pontuacaoTimeHome < this.pontuacaoTimeAway)
                this.resultBet = ResultEnum.GANHADOR_FORA;
            else
                this.resultBet = ResultEnum.EMPATE;
        }
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

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
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

    public List<Bet> getBets() {
        return (bets != null) ? bets : new ArrayList<>();
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Integer getPontuacaoTimeHome() {
        return pontuacaoTimeHome;
    }

    public void setPontuacaoTimeHome(Integer pontuacaoTimeHome) {
        this.pontuacaoTimeHome = pontuacaoTimeHome;
    }

    public Integer getPontuacaoTimeAway() {
        return pontuacaoTimeAway;
    }

    public void setPontuacaoTimeAway(Integer pontuacaoTimeAway) {
        this.pontuacaoTimeAway = pontuacaoTimeAway;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Double.compare(game.getOddTeamHome(), getOddTeamHome()) == 0 && Double.compare(game.getOddTeamAway(), getOddTeamAway()) == 0 && Double.compare(game.getOddTie(), getOddTie()) == 0 && isTerminou() == game.isTerminou() && Objects.equals(getId(), game.getId()) && Objects.equals(getTeamHome(), game.getTeamHome()) && Objects.equals(getTeamAway(), game.getTeamAway()) && getResultBet() == game.getResultBet() && Objects.equals(getCampeonato(), game.getCampeonato()) && getCategory() == game.getCategory() && Objects.equals(getCreated_at(), game.getCreated_at()) && Objects.equals(getUpdated_at(), game.getUpdated_at()) && Objects.equals(getPontuacaoTimeHome(), game.getPontuacaoTimeHome()) && Objects.equals(getPontuacaoTimeAway(), game.getPontuacaoTimeAway()) && Objects.equals(getBets(), game.getBets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTeamHome(), getTeamAway(), getResultBet(), getOddTeamHome(), getOddTeamAway(), getOddTie(), getCampeonato(), getCategory(), getCreated_at(), getUpdated_at(), isTerminou(), getPontuacaoTimeHome(), getPontuacaoTimeAway(), getBets());
    }
}