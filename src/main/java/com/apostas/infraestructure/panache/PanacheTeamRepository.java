package com.apostas.infraestructure.panache;

import com.apostas.domain.game.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheTeamRepository implements PanacheRepository<Team>  {
}
