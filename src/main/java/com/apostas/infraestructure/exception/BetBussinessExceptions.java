package com.apostas.infraestructure.exception;

public class BetBussinessExceptions extends BetExceptions{
    public BetBussinessExceptions(String msg) {
        super(msg);
    }

    public BetBussinessExceptions(String msg, Object... values) {
        super(msg, values);
    }
}
