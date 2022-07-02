package com.apostas.infraestructure.messages;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Messages {
    private static final ResourceBundle MSGS = ResourceBundle.getBundle("messages");

    private Messages() {
    }

    public static String get(String key) {
        return MSGS.getString(key);
    }

    public static String get(String key, Object... args) {
        return MessageFormat.format(get(key), args);
    }

}
