package com.apostas.application.money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyOperationTest {

    @Test
    void operationMoneyReturnCorrectMoney() {
        assertEquals("BRL 200,00", MoneyOperation.getMoney("200"));
    }

    @Test
    void operationMoneyAddFoundsCorrect() {
        assertEquals("BRL 550,72", MoneyOperation.addMoney("200.232", "350.492"));
    }

    @Test
    void operationMoneySubFoundsCorrect() {
        assertEquals("BRL -150,26", MoneyOperation.subMoney("200.232", "350.492"));
    }

    @Test
    void operationMoneyMulFoundsCorrect() {
        assertEquals("BRL 600,70", MoneyOperation.mulMoney("200.232", 3));
    }

    @Test
    void operationMoneyDivideFoundsCorrect() {
        assertEquals("BRL 66,74", MoneyOperation.divideMoney("200.232", 3));
    }

}
