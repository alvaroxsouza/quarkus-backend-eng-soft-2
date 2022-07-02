package com.apostas.domain.user;

import com.apostas.application.dto.UserDto;
import com.apostas.domain.bet.Bet;
import com.apostas.domain.enumutilities.ProfileUserEnum;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_aposta")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomeDoUsuario;

    @Column(unique = true)
    private String email;
    private String senha;
    private String dinheiroDisponivel;

    @Enumerated(EnumType.STRING)
    private ProfileUserEnum profile;
    @CreationTimestamp
    private LocalDate created_at = LocalDate.now();
    @CreationTimestamp
    private LocalDate updated_at;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Bet> betList = new ArrayList<>();

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }

    public User(UserDto userDto) {
        this.nomeDoUsuario = userDto.getNomeDoUsuario();
        this.email = userDto.getEmail();
        this.senha = userDto.getSenha();
        this.dinheiroDisponivel = "BRL 0,00";
        this.profile = ProfileUserEnum.valueOf(userDto.getProfile().toString());
        this.updated_at = LocalDate.now();
    }

    public User(String nome, String email, String senha, String perfilUsuario, LocalDate created_at, LocalDate updated_at) {
        this.nomeDoUsuario = nome;
        this.email = email;
        this.senha = senha;
        this.profile = ProfileUserEnum.valueOf(perfilUsuario);;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void updateMoneyUser(String moneyAdd) {
        this.dinheiroDisponivel = moneyAdd;
    }

    public void updateUser(UserDto userDto) {
        this.id = userDto.getId();
        this.nomeDoUsuario = userDto.getNomeDoUsuario();
        this.email = userDto.getEmail();
        this.senha = userDto.getSenha();
        this.profile = ProfileUserEnum.valueOf(userDto.getProfile().getValue());
        this.updated_at = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ProfileUserEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileUserEnum profile) {
        this.profile = profile;
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

    public List<Bet> getBetList() {
        if(this.betList == null) {
            this.betList = new ArrayList<>();
        }
        return betList;
    }

    public void setBetList(List<Bet> betList) {
        this.betList = betList;
    }

    public String getDinheiroDisponivel() {
        return (dinheiroDisponivel != null) ? this.dinheiroDisponivel : "BRL 0,00";
    }

    public void setDinheiroDisponivel(String dinheiroDisponivel) {
        this.dinheiroDisponivel = dinheiroDisponivel;
    }
}