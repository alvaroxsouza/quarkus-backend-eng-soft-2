package com.apostas.application.services;

import com.apostas.application.dto.ClosedGameDto;
import com.apostas.application.dto.GameDto;
import com.apostas.application.representation.GameRepresentation;
import com.apostas.domain.bet.GameResult;
import com.apostas.domain.game.Game;
import com.apostas.domain.repository.GameRepository;
import com.apostas.domain.repository.GameResultRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class GameResultService {
    private GameResultRepository gameResultRepository ;

    @Inject
    public GameResultService(GameResultRepository gameResultRepository) {
        super();
        this.gameResultRepository = gameResultRepository;
    }


}
