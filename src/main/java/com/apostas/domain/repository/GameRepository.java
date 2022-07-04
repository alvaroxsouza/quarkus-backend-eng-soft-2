package com.apostas.domain.repository;

import com.apostas.domain.game.Game;

import java.util.List;

public interface GameRepository extends Repository<Game, Long> {
    List<Game> getByCatorgory(String categoria);
}
