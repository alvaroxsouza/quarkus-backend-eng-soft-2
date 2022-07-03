package com.apostas.domain.enumutilities;

public enum CategoryEnum {

    FUTEBOL("Futebol"),
    VOLEI("Vôlei"),
    BASQUETE("Basquete"),
    TENIS("Tenis"),
    HANDBALL("Handball"),
    FUTEBOL_AMERICANO("Futebol Americano"),
    TENIS_DE_MESA("Tênis de mesa"),
    BASEBALL("Baseball"),
    GOLFE("Golfe"),
    FÓRMULA1("Fórmula 1"),
    FUTSAL("Futsal"),
    ESPORTE_ELETRONICO("Esporte Eletrônico"),
    OUTROS("Outros");

    private final String value;

    CategoryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
