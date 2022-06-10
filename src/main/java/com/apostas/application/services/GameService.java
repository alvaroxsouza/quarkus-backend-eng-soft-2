package com.apostas.application.services;

import com.apostas.application.dto.GameDto;
import com.apostas.domain.game.rival.Game;
import com.apostas.domain.repository.GameRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GameService {

    private GameRepository gameRepository ;

    @Inject
    public GameService(GameRepository gameRepository) {
        super();
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return this.gameRepository.all();
    }

    public void addGame(Game game) {
        this.gameRepository.add(game);
    }

    public void updateGame(GameDto gameDto) {
        Game game = this.gameRepository.get(gameDto.getId());
        game.updateGame(gameDto);
    }

    public void deleteGame(Long id) {
        Game game = this.gameRepository.get(id);
        this.gameRepository.remove(game);
    }

    public Game getGameById(Long id) {
        return this.gameRepository.get(id);
    }
}
