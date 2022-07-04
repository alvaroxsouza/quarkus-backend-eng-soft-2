package com.apostas.application.services;

import com.apostas.application.dto.ClosedGameDto;
import com.apostas.application.dto.GameDto;
import com.apostas.application.representation.GameRepresentation;
import com.apostas.domain.game.Game;
import com.apostas.domain.repository.GameRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class GameService {

    private GameRepository gameRepository ;

    @Inject
    public GameService(GameRepository gameRepository) {
        super();
        this.gameRepository = gameRepository;
    }

    public List<GameRepresentation> getAllGames() {
        return this.gameRepository.all().stream().map(GameRepresentation::new).collect(Collectors.toList());
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

    public GameRepresentation getGameById(Long id) {
        Game game = this.gameRepository.get(id);
        return new GameRepresentation(game);
    }

    public void closedGame(Long id, ClosedGameDto closedGameDto) {
        Game game = this.gameRepository.get(id);

        game.closedGame(closedGameDto);
    }

    public List<GameRepresentation> getGameByCategoria(String categoria) {
        List<Game> gameListCategoria = this.gameRepository.getByCatorgory(categoria);

        List<GameRepresentation> gameRepresentationList = gameListCategoria.stream().map(GameRepresentation::new).collect(Collectors.toList());

        return gameRepresentationList;
    }
}
