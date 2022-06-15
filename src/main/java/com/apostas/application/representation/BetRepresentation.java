package com.apostas.application.representation;

import com.apostas.domain.aposta.Bet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BetRepresentation implements Serializable {

    private Long id;
    private List<GameRepresentation> games;
    private boolean win;
    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate terminoAposta;

    public BetRepresentation() {

    }

    public BetRepresentation(Bet bet) {
        this.id = bet.getId();
        this.win = bet.isWin();
        this.games = bet.getGames().stream().map(GameRepresentation::new).collect(Collectors.toList());
        this.created_at = bet.getCreated_at();
        this.updated_at = bet.getUpdated_at();
        this.terminoAposta = bet.getTerminoAposta();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GameRepresentation> getGames() {
        return games;
    }

    public void setGames(List<GameRepresentation> games) {
        this.games = games;
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
}
