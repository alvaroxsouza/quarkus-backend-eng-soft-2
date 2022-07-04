package com.apostas.application.services;

import com.apostas.domain.repository.GameResultRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GameResultService {
    private GameResultRepository gameResultRepository ;

    @Inject
    public GameResultService(GameResultRepository gameResultRepository) {
        super();
        this.gameResultRepository = gameResultRepository;
    }


}
