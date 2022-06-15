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
    private List<BetRepresentation> betList;

    public UserRepresentation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRepresentation() {
    }

    public UserRepresentation(User user) {
        this.id = user.getId();
        this.nomeDoUsuario = user.getNomeDoUsuario();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.betList = user.getBetList().stream().map(BetRepresentation::new).collect(Collectors.toList());
        this.profile = user.getProfile();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }

    public UserRepresentation(String nome, String email, String senha, String perfilUsuario) {
        this.nomeDoUsuario = nome;
        this.email = email;
        this.senha = senha;
        this.profile = ProfileUserEnum.valueOf(perfilUsuario);
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

    public List<BetRepresentation> getBetList() {
        return betList;
    }

    public void setBetList(List<BetRepresentation> betList) {
        this.betList = betList;
    }
}
