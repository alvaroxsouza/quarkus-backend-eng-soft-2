package com.apostas.infraestructure.rest;

import com.apostas.application.dto.BetDto;
import com.apostas.application.representation.BetRepresentation;
import com.apostas.application.services.BetService;
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
    @Operation(summary = "Obtém todas as apostas da base.")
    public List<BetRepresentation> getAllBet() {
        return this.betService.getAllBets();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém uma aposta na base pelo seu ID.")
    public BetRepresentation getBetById(@PathParam("id") Long id) {
        return this.betService.getBetById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona uma aposta na base.")
    public Response addBet(BetDto betDto) {
        this.betService.addBet(betDto);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Altera uma aposta na base.")
    public Response updateBet(@PathParam("id") Long id, BetDto betDto) {
        betDto.setId(id);
        this.betService.updateBet(betDto);
        return Response.ok().build();
    }

    @PATCH
    @Path("award/{id}")
    @Transactional
    @Operation(summary = "Solicita a premiação de uma aposta ganha pelo usuário.")
    public Response awardBet(@PathParam("id") Long idBet) {
        this.betService.awardBet(idBet);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta uma aposta na base.")
    public Response deleteBet(@PathParam("id") Long id) {
        this.betService.deleteBet(id);
        return Response.ok().build();
    }
}
