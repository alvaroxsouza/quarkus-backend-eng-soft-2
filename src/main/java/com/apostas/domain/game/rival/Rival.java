package com.apostas.domain.game.rival;

import javax.persistence.*;

@Entity
@Table(name = "rival")
public class Rival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomeRival;

    private String paisDeOrigem;

    private String campeonato;

    public Rival() {
    }

    public Rival(Long id, String nomeRival, String paisDeOrigem, String campeonato) {
        this.id = id;
        this.nomeRival = nomeRival;
        this.paisDeOrigem = paisDeOrigem;
        this.campeonato = campeonato;
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

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }
}
