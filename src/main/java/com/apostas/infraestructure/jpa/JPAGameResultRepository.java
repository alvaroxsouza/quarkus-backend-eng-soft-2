package com.apostas.infraestructure.jpa;

import com.apostas.domain.bet.GameResult;
import com.apostas.domain.repository.GameResultRepository;
import com.apostas.infraestructure.panache.PanacheGameResultRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPAGameResultRepository implements GameResultRepository {
    private PanacheGameResultRepository panacheGameResultRepository;

    @Inject
    public JPAGameResultRepository(PanacheGameResultRepository panacheGameResultRepository) {
        this.panacheGameResultRepository = panacheGameResultRepository;
    }

    @Override
    public void add(GameResult obj) {
        this.panacheGameResultRepository.persist(obj);
    }

    @Override
    public void remove(GameResult obj) {
        this.panacheGameResultRepository.delete(obj);
    }

    @Override
    public GameResult get(Long id) {
        return this.panacheGameResultRepository.findById(id);
    }

    @Override
    public boolean exists(GameResult obj) {
        return this.get(obj.getId()) != null;
    }

    @Override
    public List<GameResult> all() {
        return this.panacheGameResultRepository.listAll();
    }

    @Override
    public List<GameResult> getByGameResult(Long id) {
        return this.panacheGameResultRepository.getByGameResult(id);
    }
}
