package com.apostas.application.money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

public class MoneyOperation {

    private static CurrencyUnit currencyUnit = Monetary.getCurrency("BRL");
    private static Locale localBrasil = new Locale("pt", "BR");
    private static MonetaryAmountFormat formatBRL = MonetaryFormats.getAmountFormat(localBrasil);

    public static String getMoney(String moneyActual) {
        BigInteger moneyConverter = new BigInteger(moneyActual);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyConverter).create();
        return formatBRL.format(amountActualBrl);
    }

    public static String addMoney(String moneyActual, String moneyAdd) {
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneyAdd);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();
        MonetaryAmount amountAddBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyAddConverter).create();

        amountActualBrl = amountActualBrl.add(amountAddBrl).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String subMoney(String moneyActual, String moneySub) {
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneySub);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();
        MonetaryAmount amountAddBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyAddConverter).create();

        amountActualBrl = amountActualBrl.subtract(amountAddBrl).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String mulMoney(String moneyActual, double moneyMult) {
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneyMult);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();

        amountActualBrl = amountActualBrl.multiply(moneyMult).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }

    public static String divideMoney(String moneyActual, double moneyDiv) {
        BigDecimal moneyActualConverter = new BigDecimal(moneyActual);
        BigDecimal moneyAddConverter = new BigDecimal(moneyDiv);

        MonetaryAmount amountActualBrl = Monetary.getDefaultAmountFactory().setCurrency(currencyUnit).setNumber(moneyActualConverter).create();

        amountActualBrl = amountActualBrl.divide(moneyDiv).with(Monetary.getDefaultRounding());

        return formatBRL.format(amountActualBrl);
    }
}
