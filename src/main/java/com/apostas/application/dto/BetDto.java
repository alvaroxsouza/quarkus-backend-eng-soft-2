package com.apostas.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BetDto implements Serializable {
    @JsonIgnore
    private Long id;
    private List<GameDto> games;
    private Long idUser;
    private boolean win;
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at;
    private LocalDate terminoAposta;

    public BetDto() {
    }

    public BetDto(Long id, List<GameDto> games, Long idUser, boolean win, LocalDate created_at, LocalDate updated_at, LocalDate terminoAposta) {
        this.id = id;
        this.games = games;
        this.idUser = idUser;
        this.win = win;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.terminoAposta = terminoAposta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GameDto> getGames() {
        return games;
    }

    public void setGames(List<GameDto> games) {
        this.games = games;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetDto entity = (BetDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.games, entity.games) &&
                Objects.equals(this.idUser, entity.idUser) &&
                Objects.equals(this.win, entity.win) &&
                Objects.equals(this.created_at, entity.created_at) &&
                Objects.equals(this.updated_at, entity.updated_at) &&
                Objects.equals(this.terminoAposta, entity.terminoAposta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, games, idUser, win, created_at, updated_at, terminoAposta);
    }
}
