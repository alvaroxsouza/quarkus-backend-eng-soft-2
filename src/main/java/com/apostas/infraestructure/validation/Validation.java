package com.apostas.infraestructure.validation;

import com.apostas.infraestructure.exception.BetBussinessExceptions;
import com.apostas.infraestructure.exception.BetExceptions;
import com.apostas.infraestructure.messages.Messages;
import org.apache.commons.lang3.Validate;

public class Validation {

    private Validation() {

    }

    public static void notNull(Object obj, String fieldName) throws BetExceptions {
        try {
            Validate.notNull(obj, Messages.get("nullvalue", fieldName));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }

    public static void notEmpty(Object[] array, String fieldName) throws BetExceptions {
        try {
            Validate.notEmpty(array, Messages.get("Empty", fieldName));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }

    public static void notBlank(String text, String fieldName) throws BetExceptions {
        try {
            Validate.notBlank(text, Messages.get("Empty", fieldName));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }

    public static void size(String string, long min, long max, String fieldName) throws BetExceptions {
        try {
            Validate.inclusiveBetween(min, max, string.length(), Messages.get("Size", fieldName, min, max));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }

    public static void email(String email) throws BetExceptions {
        try {
            Validate.matchesPattern(email,
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                    Messages.get("Email"));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }

    public static void semCaracterEspecial(String text, String fieldName) throws BetExceptions {
        try {
            Validate.matchesPattern(text, "[_A-Za-z0-9]+", Messages.get("Caracter-especial", fieldName));
        } catch (Exception e) {
            throw new BetBussinessExceptions(e.getMessage());
        }
    }
}
