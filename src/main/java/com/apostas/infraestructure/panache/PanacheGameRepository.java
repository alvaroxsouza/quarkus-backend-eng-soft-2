package com.apostas.infraestructure.panache;

import com.apostas.domain.game.rival.Game;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheGameRepository implements PanacheRepository<Game>  {
}
