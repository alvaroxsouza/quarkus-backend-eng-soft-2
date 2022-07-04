package com.apostas.infraestructure.panache;

import com.apostas.domain.enumutilities.CategoryEnum;
import com.apostas.domain.game.Game;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PanacheGameRepository implements PanacheRepository<Game>  {
    public List<Game> getByCatogory(String categoria) {
        var enumValue = CategoryEnum.valueOf(categoria);
        return this.find("category", enumValue).list();
    }
}
