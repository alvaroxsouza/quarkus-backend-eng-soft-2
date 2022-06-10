package com.apostas.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class RivalDto implements Serializable {
    @JsonIgnore
    private Long id;
    private String nomeRival;
    private String paisDeOrigem;

    public RivalDto() {
    }

    public RivalDto(Long id, String nomeRival, String paisDeOrigem) {
        this.id = id;
        this.nomeRival = nomeRival;
        this.paisDeOrigem = paisDeOrigem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRival() {
        return nomeRival;
    }

    public void setNomeRival(String nomeRival) {
        this.nomeRival = nomeRival;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RivalDto entity = (RivalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nomeRival, entity.nomeRival) &&
                Objects.equals(this.paisDeOrigem, entity.paisDeOrigem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeRival, paisDeOrigem);
    }
}
