package com.apostas.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDto implements Serializable {
    @JsonIgnore
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String perfilUsuario;
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at;

    public UserDto() {
    }

    public UserDto(Long id, String nome, String email, String senha, String perfilUsuario, LocalDate created_at, LocalDate updated_at) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfilUsuario = perfilUsuario;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.senha, entity.senha) &&
                Objects.equals(this.perfilUsuario, entity.perfilUsuario) &&
                Objects.equals(this.created_at, entity.created_at) &&
                Objects.equals(this.updated_at, entity.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha, perfilUsuario, created_at, updated_at);
    }
}
