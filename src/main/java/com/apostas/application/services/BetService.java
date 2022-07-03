package com.apostas.application.services;

import com.apostas.application.dto.BetDto;
import com.apostas.application.money.MoneyOperation;
import com.apostas.application.money.OddCalculator;
import com.apostas.application.representation.BetRepresentation;
import com.apostas.domain.bet.Bet;
import com.apostas.domain.bet.GameResult;
import com.apostas.domain.enumutilities.ResultEnum;
import com.apostas.domain.game.Game;
import com.apostas.domain.repository.BetRepository;
import com.apostas.domain.repository.GameRepository;
import com.apostas.domain.repository.GameResultRepository;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class BetService {

    private BetRepository betRepository;
    private UserRepository userRepository;
    private GameRepository gameRepository;
    private GameResultRepository gameResultRepository;

    @Inject
    public BetService(BetRepository betRepository, UserRepository userRepository, GameRepository gameRepository, GameResultRepository gameResultRepository) {
        super();
        this.betRepository = betRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.gameResultRepository = gameResultRepository;
    }

    public List<BetRepresentation> getAllBets() {
        return this.betRepository.all().stream().map(BetRepresentation::new).collect(Collectors.toList());
    }

    public void addBet(BetDto betDto) {
        Bet bet = new Bet(betDto);
        if(bet != null) {
            this.betRepository.add(bet);
            User user = this.userRepository.get(betDto.getIdUser());
            String newMoney = MoneyOperation.subMoney(user.getDinheiroDisponivel(), betDto.getBetValue());
            user.setDinheiroDisponivel(newMoney);
        }
    }

    public void updateBet(BetDto betDto) {
        Bet bet = this.betRepository.get(betDto.getId());
        bet.updateBet(betDto);
    }

    public void deleteBet(Long id) {
        Bet bet = this.betRepository.get(id);
        this.betRepository.remove(bet);
    }

    public BetRepresentation getBetById(Long id) {
        Bet bet = this.betRepository.get(id);

        return new BetRepresentation(bet);
    }

    private List<Game> listarGamesDaBase(BetDto betDto) {
        List<Game> gameList = new ArrayList<>();
        betDto.getGames().forEach(gameId -> {
            gameList.add(gameRepository.get(gameId));
        });
        return gameList;
    }

    public void awardBet(Long idBet) {
        Bet bet = this.betRepository.get(idBet);
        System.out.println(bet.getUser().toString());
    }

    /*
     * Retorna o quanto usuário ganhou na aposta e faz o set do dinheiro atual do usuário.
     * Parte do pressuposto que todos os jogos terminaram.
     */
//    public String resultGain(BetDto betDto) {
//        Bet bet = this.betRepository.get(betDto.getId());
//        User user = this.userRepository.get(betDto.getIdUser());
//        for (Game game : bet.getGames()) {
////            game.whoWon();
//            ResultEnum gameResult = bet.getGameResult().get(bet.getGameResult().indexOf(game.getId())).getResult();
//            if(!game.getResultBet().equals(gameResult)){
//                return new String("Perdeu!");
//            }
//        }
//        double multOdd = OddCalculator.multOdds(bet, user);
//        String newMoney = MoneyOperation.mulMoney(bet.getMoneyBet(), multOdd);
//        user.setDinheiroDisponivel(MoneyOperation.addMoney(user.getDinheiroDisponivel(), newMoney));
//        return newMoney;
//    }
}
