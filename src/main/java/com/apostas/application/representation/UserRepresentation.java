package com.apostas.application.representation;

import com.apostas.domain.enumutilities.ProfileUserEnum;
import com.apostas.domain.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepresentation implements Serializable {

    private Long id;
    private String nomeDoUsuario;
    private String email;
    private String senha;
    private LocalDate created_at;
    private LocalDate updated_at;
    private ProfileUserEnum profile;
    private String dinheiroDisponivel;
    private List<BetRepresentation> betList;

    public UserRepresentation(Long id) {
        this.id = id;
    }

    public UserRepresentation() {
    }

    public UserRepresentation(User user) {
        this.id = user.getId();
        this.nomeDoUsuario = user.getNomeDoUsuario();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.dinheiroDisponivel = user.getDinheiroDisponivel();
        this.betList = user.getBetList().stream().map(BetRepresentation::new).collect(Collectors.toList());
        this.profile = user.getProfile();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }

    public UserRepresentation(Long id, String nomeDoUsuario, String email, String senha, LocalDate created_at, LocalDate updated_at, ProfileUserEnum profile, String dinheiroDisponivel, List<BetRepresentation> betList) {
        this.id = id;
        this.nomeDoUsuario = nomeDoUsuario;
        this.email = email;
        this.senha = senha;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.profile = profile;
        this.dinheiroDisponivel = dinheiroDisponivel;
        this.betList = betList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDinheiroDisponivel() {
        return dinheiroDisponivel;
    }

    public void setDinheiroDisponivel(String dinheiroDisponivel) {
        this.dinheiroDisponivel = dinheiroDisponivel;
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

    public ProfileUserEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileUserEnum profile) {
        this.profile = profile;
    }

    public List<BetRepresentation> getBetList() {
        return betList;
    }

    public void setBetList(List<BetRepresentation> betList) {
        this.betList = betList;
    }
}
