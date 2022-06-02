package com.apostas.domain.user;

import com.apostas.application.dto.UserDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "user_aposta")
public class User extends PanacheEntity {

    private String nomeDoUsuario;

    private String email;

    private String senha;

    private boolean administrador;

    @CreationTimestamp
    private LocalDate created_at = LocalDate.now();

    @CreationTimestamp
    private LocalDate updated_at;

    public User() {

    }

    public User(UserDto userDto) {
        this.nomeDoUsuario = userDto.getNome();
        this.email = userDto.getEmail();
        this.senha = userDto.getSenha();
        this.administrador = userDto.getAdministrador();
        this.updated_at = LocalDate.now();
    }

    public User(String nome, String email, String senha, boolean administrador, LocalDate created_at, LocalDate updated_at) {
        this.nomeDoUsuario = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nome) {
        this.nomeDoUsuario = nome;
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

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
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

    public void updateUser(UserDto userDto) {
        this.id = userDto.getId();
        this.nomeDoUsuario = userDto.getNome();
        this.email = userDto.getEmail();
        this.senha = userDto.getSenha();
        this.administrador = userDto.getAdministrador();
        this.updated_at = LocalDate.now();
    }
}