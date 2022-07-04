package com.apostas.infraestructure.rest;

import com.apostas.application.dto.ClosedGameDto;
import com.apostas.application.dto.GameDto;
import com.apostas.application.representation.GameRepresentation;
import com.apostas.application.services.GameService;
import com.apostas.domain.game.Game;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("game")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private GameService gameService;

    @Inject
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }

    @GET
    @Operation(summary = "Obtém todos os jogos da base.")
    public List<GameRepresentation> getAllGames() {
        return this.gameService.getAllGames();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um jogo pelo seu ID na base.")
    public GameRepresentation getGameById(@PathParam("id") Long id) {
        return this.gameService.getGameById(id);
    }

    @GET
    @Path("{categoria}")
    @Operation(summary = "Obtém um jogo pelo seu ID na base.")
    public List<GameRepresentation> getGameById(@PathParam("categoria") String categoria) {
        return this.gameService.getGameByCategoria(categoria);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um jogo na base.")
    public Response addGame(GameDto gameDto) {
        Game game = new Game(gameDto);
        if(game != null) {
            this.gameService.addGame(game);
        }
        return Response.ok().build();
    }

    @PATCH
    @Path("closed/{id}")
    @Transactional
    @Operation(summary = "Fecha/Termina um jogo na base.")
    public Response closeGame(@PathParam("id") Long id, ClosedGameDto closedGameDto) {
        this.gameService.closedGame(id, closedGameDto);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um jogo na base.")
    public Response updateGame(@PathParam("id") Long id, GameDto gameDto) {
        gameDto.setId(id);
        this.gameService.updateGame(gameDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um jogo na base.")
    public Response deleteGame(@PathParam("id") Long id) {
        this.gameService.deleteGame(id);
        return Response.ok().build();
    }
}
