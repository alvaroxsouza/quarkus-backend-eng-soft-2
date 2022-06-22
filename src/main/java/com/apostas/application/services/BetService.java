package com.apostas.application.services;

import com.apostas.application.dto.BetDto;
import com.apostas.application.representation.BetRepresentation;
import com.apostas.domain.aposta.Bet;
import com.apostas.domain.game.Game;
import com.apostas.domain.repository.BetRepository;
import com.apostas.domain.repository.GameRepository;
import com.apostas.domain.repository.UserRepository;

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

    @Inject
    public BetService(BetRepository betRepository, UserRepository userRepository, GameRepository gameRepository) {
        super();
        this.betRepository = betRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public List<BetRepresentation> getAllBets() {
        return this.betRepository.all().stream().map(BetRepresentation::new).collect(Collectors.toList());
    }

    public void addBet(Bet bet) {
        this.betRepository.add(bet);
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

    public void addBetInUser(BetDto betDto) {

    }
}
