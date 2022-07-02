package com.apostas.application.money;

import javax.enterprise.inject.spi.Bean;

import com.apostas.application.dto.BetDto;
import com.apostas.application.dto.GameDto;
import com.apostas.infraestructure.jpa.JPAGameRepository;

public class OddCalculator {
    /*
     * Calcula o valor da odd em porcentagem. 100/odd
     */
    public static String multiplierToPercentage(double odd) {
        int value = (int) (100/odd);
        return new String(value + "%");
    }

    public static double oddsMutiplier(BetDto bet) {
        for (Long idGame : bet.getGames()) {
            Game game = JPAGameRepository.get(idGame);
        }
    }
}
