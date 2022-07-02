package com.apostas.infraestructure.jpa;

import com.apostas.domain.bet.Bet;
import com.apostas.domain.repository.BetRepository;
import com.apostas.infraestructure.panache.PanacheBetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPABetRepository implements BetRepository {
    private PanacheBetRepository panacheBetRepository;

    @Inject
    public JPABetRepository(PanacheBetRepository panacheBetRepository) {
        this.panacheBetRepository = panacheBetRepository;
    }

    @Override
    public void add(Bet obj) {
        this.panacheBetRepository.persist(obj);
    }

    @Override
    public void remove(Bet obj) {
        this.panacheBetRepository.delete(obj);
    }

    @Override
    public Bet get(Long id) {
        return this.panacheBetRepository.findById(id);
    }

    @Override
    public boolean exists(Bet obj) {
        return this.get(obj.getId()) != null;
    }

    @Override
    public List<Bet> all() {
        return this.panacheBetRepository.listAll();
    }
}
