package com.apostas.application.money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyOperationTest {

    @Test
    void operationMoneyReturnCorrectMoney() {
        assertEquals("BRL 200,00", MoneyOperation.getMoney("BRL 200,00"));
    }

    @Test
    void operationMoneyAddFoundsCorrect() {
        assertEquals("BRL 550,72", MoneyOperation.addMoney("BRL 200,232", "350.492"));
    }

    @Test
    void operationMoneyAddFoundsCentsCorrect() {
        assertEquals("BRL 0,70", MoneyOperation.addMoney("BRL 000,5", "0.2"));
    }

    @Test
    void operationMoneyAddFoundsMoneyActualCorrect() {
        assertEquals("BRL 2.550,72", MoneyOperation.addMoney("BRL 2.200,232", "350.492"));
    }

    @Test
    void operationMoneyWithdrawFoundsMoneyEqualValuesSuccessCorrect() {
        assertTrue(MoneyOperation.biggerThenOrEqual("BRL 200,00","200.00"));
    }

    @Test
    void operationMoneyWithdrawFoundsMoneyBiggerThenSuccessCorrect() {
        assertTrue(MoneyOperation.biggerThenOrEqual("BRL 250,00","200.00"));
    }

    @Test
    void operationMoneyWithdrawFoundsMoneyBiggerThenFailedCorrect() {
        assertFalse(MoneyOperation.biggerThenOrEqual("BRL 200,00","250.00"));
    }

    @Test
    void operationMoneyAddFoundsMoneyActualMillionCorrect() {
        assertEquals("BRL 2.000.550,72", MoneyOperation.addMoney("BRL 2.000.200,232", "350.492"));
    }

    @Test
    void operationMoneySubFoundsCorrect() {
        assertEquals("BRL -150,26", MoneyOperation.subMoney("BRL 200,232", "350.492"));
    }

    @Test
    void operationMoneyMulFoundsCorrect() {
        assertEquals("BRL 600,70", MoneyOperation.mulMoney("BRL 200,232", 3));
    }

    @Test
    void operationMoneyDivideFoundsCorrect() {
        assertEquals("BRL 66,74", MoneyOperation.divideMoney("BRL 200,232", 3));
    }

}
