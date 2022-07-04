package com.apostas.infraestructure.panache;

import com.apostas.domain.bet.GameResult;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PanacheGameResultRepository implements PanacheRepository<GameResult> {
    public List<GameResult> getByGameResult(Long id) {
        return find("from GameResult gr join fetch gr.game where gr.game.id = :id", Parameters.with("id", id)).list();
    }
}
