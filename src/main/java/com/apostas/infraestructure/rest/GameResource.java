package com.apostas.infraestructure.rest;

import com.apostas.application.dto.GameDto;
import com.apostas.application.dto.UserDto;
import com.apostas.application.services.GameService;
import com.apostas.application.services.UserService;
import com.apostas.domain.game.rival.Game;
import com.apostas.domain.user.User;
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
    @Operation(summary = "Obtém todos os usuários da base.")
    public List<Game> getAllGames() {
        return this.gameService.getAllGames();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um usuário por ID na base.")
    public Game getGameById(@PathParam("id") Long id) {
        return this.gameService.getGameById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um usuário na base.")
    public Response addGame(GameDto gameDto) {
        Game game = new Game(gameDto);
        if(game != null) {
            this.gameService.addGame(game);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um usuário na base.")
    public Response updateGame(@PathParam("id") Long id, GameDto gameDto) {
        gameDto.setId(id);
        this.gameService.updateGame(gameDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um usuário na base.")
    public Response deleteGame(@PathParam("id") Long id) {
        this.gameService.deleteGame(id);
        return Response.ok().build();
    }
}
