package com.apostas.application.services;

import com.apostas.application.dto.BetDto;
import com.apostas.domain.aposta.Bet;
import com.apostas.domain.repository.BetRepository;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BetService {

    private BetRepository betRepository;

    @Inject
    public BetService(BetRepository betRepository) {
        super();
        this.betRepository = betRepository;
    }

    public List<Bet> getAllBets() {
        return this.betRepository.all();
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

    public Bet getBetById(Long id) {
        return this.betRepository.get(id);
    }
}
