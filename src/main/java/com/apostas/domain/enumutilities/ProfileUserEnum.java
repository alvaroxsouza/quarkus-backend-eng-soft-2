package com.apostas.domain.enumutilities;

public enum ProfileUserEnum {

    APOSTADOR("Apostador"),
    ADMINISTRADOR("Administrador");

    private final String value;

    ProfileUserEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
