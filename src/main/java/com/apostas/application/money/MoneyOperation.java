package com.apostas.application.money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.math.BigDecimal;
import java.util.Locale;

public class MoneyOperation {

    private static CurrencyUnit currencyUnit = Monetary.getCurrency("BRL");
    private static Locale localBrasil = new Locale("pt", "BR");
    private static MonetaryAmountFormat formatBRL = MonetaryFormats.getAmountFormat(localBrasil);

    public static String getMoney(String moneyActual) {
        moneyActual = formatStringDecimal(moneyActual);
        BigDecimal moneyConverter = new BigDecimal(moneyActual);
        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyConverter).create();
        return formatBRL.format(amountActualBrl);
    }

    public static String addMoney(String moneyActual, String moneyAdd) {
        moneyActual = formatStringDecimal(moneyActual);

        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneyAdd);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();
        MonetaryAmount amountAddBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyAddConverter).create();

        amountActualBrl = amountActualBrl.add(amountAddBrl).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String subMoney(String moneyActual, String moneySub) {
        moneyActual = formatStringDecimal(moneyActual);

        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneySub);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();
        MonetaryAmount amountAddBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyAddConverter).create();

        amountActualBrl = amountActualBrl.subtract(amountAddBrl).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String mulMoney(String moneyActual, double moneyMult) {
        moneyActual = formatStringDecimal(moneyActual);
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();

        amountActualBrl = amountActualBrl.multiply(moneyMult).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String divideMoney(String moneyActual, double moneyDiv) {
        moneyActual = formatStringDecimal(moneyActual);
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();

        amountActualBrl = amountActualBrl.divide(moneyDiv).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    private static String formatStringDecimal(String money) {
        var divide = money.split(",");

        var maxPart = divide[0];

        maxPart = removeSimbolMonetary(maxPart);

        var minPart = divide[1];
        return maxPart + "." + minPart;
    }

    private static String removeSimbolMonetary(String maxPart) {
        var divide = maxPart.split(" ");
        return divide[1];
    }

}
