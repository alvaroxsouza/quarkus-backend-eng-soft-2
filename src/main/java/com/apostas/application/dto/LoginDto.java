package com.apostas.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class LoginDto implements Serializable {
    private String email;
    private String senha;

    public LoginDto() {
    }

    public LoginDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDto entity = (LoginDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.senha, entity.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha);
    }
}
