package com.apostas.application.services;

import com.apostas.application.dto.BetDto;
import com.apostas.application.money.MoneyOperation;
import com.apostas.application.representation.BetRepresentation;
import com.apostas.domain.bet.Bet;
import com.apostas.domain.bet.GameResult;
import com.apostas.domain.game.Game;
import com.apostas.domain.repository.BetRepository;
import com.apostas.domain.repository.GameRepository;
import com.apostas.domain.repository.GameResultRepository;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;
import com.apostas.infraestructure.exception.BetBussinessExceptions;

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
        bet.setMoneyIfWin(calculateMoneyIfWin(bet));
        if(bet != null) {
            this.betRepository.add(bet);
            User user = this.userRepository.get(betDto.getIdUser());
            if(MoneyOperation.biggerThenOrEqual(user.getDinheiroDisponivel(), bet.getMoneyBet())) {
                String newMoney = MoneyOperation.subMoney(user.getDinheiroDisponivel(), bet.getMoneyBet());
                user.setDinheiroDisponivel(newMoney);
            } else {
                throw new BetBussinessExceptions("dinheiro-insuficiente");
            }
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
        boolean ganhou = true;

        List<Game> gameList = bet.getGames();
        List<GameResult> gameResultList = bet.getGameResult();

        if(allGamesTerminate(gameList)) {
            if(!resultGain(gameList, gameResultList)) {
                throw new BetBussinessExceptions("nao-ganhou");
            } else {
                bet.getUser().setDinheiroDisponivel(MoneyOperation.addMoney(bet.getUser().getDinheiroDisponivel(), bet.getMoneyIfWin()));
            }
        } else {
            throw new BetBussinessExceptions("jogos-nao-terminaram");
        }
    }

    private boolean resultGain(List<Game> gameList, List<GameResult> gameResultList) {
        for(Game game : gameList) {
            for(GameResult result : gameResultList) {
                if(game.equals(result.getGame()) && !game.getResultBet().equals(result.getResult())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean allGamesTerminate(List<Game> listaDeJogos) {
        for(Game game : listaDeJogos) {
            if(!game.isTerminou()) {
                return false;
            }
        }
        return true;
    }

    private String calculateMoneyIfWin(Bet bet) {
        String money = "";
        double oddTotal = 1.0;
        for (Game game : bet.getGames()) {
            oddTotal = calculateOddTotal(bet, oddTotal, game);
        }
        money = MoneyOperation.mulMoney(bet.getMoneyIfWin(), oddTotal);
        return money;
    }

    private double calculateOddTotal(Bet bet, double oddTotal, Game game) {
        for(GameResult result : bet.getGameResult()) {
            if(game.equals(result.getGame())) {
                switch (result.getResult()) {
                    case GANHADOR_CASA:
                        oddTotal *= game.getOddTeamHome();
                        break;
                    case GANHADOR_FORA:
                        oddTotal *= game.getOddTeamAway();
                        break;
                    case EMPATE:
                        oddTotal *= game.getOddTie();
                        break;
                }
            }
        }
        return oddTotal;
    }
}
