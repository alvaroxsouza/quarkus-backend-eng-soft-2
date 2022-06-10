package com.apostas.infraestructure.panache;

import com.apostas.domain.game.rival.Rival;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheRivalRepository implements PanacheRepository<Rival>  {
}
