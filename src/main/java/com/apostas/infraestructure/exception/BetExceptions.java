package com.apostas.infraestructure.exception;

import java.text.MessageFormat;

public class BetExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BetExceptions(String msg) {
        super(msg);
    }

    public BetExceptions(String msg, Object... values) {
        super(MessageFormat.format(msg, values));
    }

}
