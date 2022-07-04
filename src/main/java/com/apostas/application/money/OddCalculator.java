package com.apostas.application.money;

import com.apostas.domain.bet.Bet;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.Game;

public class OddCalculator {
    /*
     * Calcula o valor da odd em porcentagem. 100/odd
     */
    public static String multiplierToPercentage(double odd) {
        int value = (int) (100/odd);
        return new String(value + "%");
    }

    /*
     * Multiplica todas as odds de uma aposta.
     */
    public static double multOdds(Bet bet) {
//        Começa de 1 porque é elemento neutro da multiplicação
        double odd = 1;
        for (Game game : bet.getGames()) {
            ResultEnum gameResult = bet.getGameResult().get(bet.getGameResult().indexOf(game.getId())).getResult();
            switch (gameResult) {
                case EMPATE:
                    odd *= game.getOddTie();
                    break;
                case GANHADOR_CASA:
                    odd *= game.getOddTeamHome();
                    break;
                case GANHADOR_FORA:
                    odd *= game.getOddTeamAway();
                    break;
            }
        }
        return odd;
    }
}
