package com.apostas.infraestructure.rest;

import com.apostas.application.dto.BetDto;
import com.apostas.application.services.BetService;
import com.apostas.application.services.UserService;
import com.apostas.domain.aposta.Bet;
import com.apostas.domain.user.User;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("bet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BetResource {

    private BetService betService;

    @Inject
    public BetResource(BetService betService) {
        this.betService = betService;
    }

    @GET
    @Operation(summary = "Obtém todos os usuários da base.")
    public List<Bet> getAllBet() {
        return this.betService.getAllBets();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um usuário por ID na base.")
    public Bet getBetById(@PathParam("id") Long id) {
        return this.betService.getBetById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um usuário na base.")
    public Response addBet(BetDto betDto) {
        Bet bet = new Bet(betDto);
        if(bet != null) {
            this.betService.addBet(bet);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um usuário na base.")
    public Response updateBet(@PathParam("id") Long id, BetDto betDto) {
        betDto.setId(id);
        this.betService.updateBet(betDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um usuário na base.")
    public Response deleteBet(@PathParam("id") Long id) {
        this.betService.deleteBet(id);
        return Response.ok().build();
    }
}
