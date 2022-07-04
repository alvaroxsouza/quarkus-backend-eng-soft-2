package com.apostas.infraestructure.jpa;

import com.apostas.domain.game.Game;
import com.apostas.domain.repository.GameRepository;
import com.apostas.infraestructure.panache.PanacheGameRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPAGameRepository implements GameRepository {
    private PanacheGameRepository panacheGameRepository;

    @Inject
    public JPAGameRepository(PanacheGameRepository panacheGameRepository) {
        this.panacheGameRepository = panacheGameRepository;
    }

    @Override
    public void add(Game obj) {
        this.panacheGameRepository.persist(obj);
    }

    @Override
    public void remove(Game obj) {
        this.panacheGameRepository.delete(obj);
    }

    @Override
    public Game get(Long id) {
        return this.panacheGameRepository.findById(id);
    }

    @Override
    public boolean exists(Game obj) {
        return this.get(obj.getId()) != null;
    }

    @Override
    public List<Game> all() {
        return this.panacheGameRepository.listAll();
    }

    @Override
    public List<Game> getByCatorgory(String categoria) {
        return this.panacheGameRepository.getByCatogory(categoria);
    }
}
