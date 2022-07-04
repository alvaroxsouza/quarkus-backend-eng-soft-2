package com.apostas.infraestructure.panache;

import com.apostas.domain.bet.Bet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheBetRepository implements PanacheRepository<Bet>  {
}
