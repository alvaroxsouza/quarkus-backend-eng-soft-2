package com.apostas.domain.game.rival;

import com.apostas.application.dto.RivalDto;

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

    public Rival() {
    }

    public Rival(Long id, String nomeRival, String paisDeOrigem) {
        this.id = id;
        this.nomeRival = nomeRival;
        this.paisDeOrigem = paisDeOrigem;
    }

    public Rival(RivalDto rivalDto) {
        this.id = rivalDto.getId();
        this.nomeRival = rivalDto.getNomeRival();
        this.paisDeOrigem = rivalDto.getPaisDeOrigem();
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

    public void updateRival(RivalDto rivalDto) {
        this.id = rivalDto.getId();
        this.nomeRival = rivalDto.getNomeRival();
        this.paisDeOrigem = rivalDto.getPaisDeOrigem();
    }
}
