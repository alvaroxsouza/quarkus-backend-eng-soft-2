package com.apostas.infraestructure.rest;

import com.apostas.application.dto.RivalDto;
import com.apostas.application.representation.RivalRepresentation;
import com.apostas.application.services.RivalService;
import com.apostas.domain.game.rival.Rival;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("rival")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RivalResource {

    private RivalService rivalService;

    @Inject
    public RivalResource(RivalService rivalService) {
        this.rivalService = rivalService;
    }

    @GET
    @Operation(summary = "Obtém todos os usuários da base.")
    public List<RivalRepresentation> getAllRivals() {
        return this.rivalService.getAllRivals();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um usuário por ID na base.")
    public RivalRepresentation getRivalById(@PathParam("id") Long id) {
        return this.rivalService.getRivalById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um usuário na base.")
    public Response addRival(RivalDto rivalDto) {
        Rival rival = new Rival(rivalDto);
        if(rival != null) {
            this.rivalService.addRival(rival);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um usuário na base.")
    public Response updateRival(@PathParam("id") Long id, RivalDto rivalDto) {
        rivalDto.setId(id);
        this.rivalService.updateRival(rivalDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um usuário na base.")
    public Response deleteRival(@PathParam("id") Long id) {
        this.rivalService.deleteRival(id);
        return Response.ok().build();
    }
}
