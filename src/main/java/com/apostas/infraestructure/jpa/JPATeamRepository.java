package com.apostas.infraestructure.jpa;

import com.apostas.domain.game.Team;
import com.apostas.domain.repository.TeamRepository;
import com.apostas.infraestructure.panache.PanacheTeamRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPATeamRepository implements TeamRepository {
    private PanacheTeamRepository panacheTeamRepository;

    @Inject
    public JPATeamRepository(PanacheTeamRepository panacheTeamRepository) {
        this.panacheTeamRepository = panacheTeamRepository;
    }

    @Override
    public void add(Team obj) {
        this.panacheTeamRepository.persist(obj);
    }

    @Override
    public void remove(Team obj) {
        this.panacheTeamRepository.delete(obj);
    }

    @Override
    public Team get(Long id) {
        return this.panacheTeamRepository.findById(id);
    }

    @Override
    public boolean exists(Team obj) {
        return this.get(obj.getId()) != null;
    }

    @Override
    public List<Team> all() {
        return this.panacheTeamRepository.listAll();
    }
}
