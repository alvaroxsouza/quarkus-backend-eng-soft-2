package com.apostas.domain.enumutilities;

public enum ResultEnum {

    GANHADOR_CASA("Casa Ganhou"),
    GANHADOR_FORA("Fora Ganhou"),
    EMPATE("Empate");

    private final String value;

    ResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
