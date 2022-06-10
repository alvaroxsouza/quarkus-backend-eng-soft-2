package com.apostas.infraestructure.jpa;

import com.apostas.domain.game.rival.Rival;
import com.apostas.domain.repository.RivalRepository;
import com.apostas.infraestructure.panache.PanacheRivalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPARivalRepository implements RivalRepository {
    private PanacheRivalRepository panacheRivalRepository;

    @Inject
    public JPARivalRepository(PanacheRivalRepository panacheRivalRepository) {
        this.panacheRivalRepository = panacheRivalRepository;
    }

    @Override
    public void add(Rival obj) {
        this.panacheRivalRepository.persist(obj);
    }

    @Override
    public void remove(Rival obj) {
        this.panacheRivalRepository.delete(obj);
    }

    @Override
    public Rival get(Long id) {
        return this.panacheRivalRepository.findById(id);
    }

    @Override
    public boolean exists(Rival obj) {
        return this.get(obj.getId()) != null;
    }

    @Override
    public List<Rival> all() {
        return this.panacheRivalRepository.listAll();
    }
}
