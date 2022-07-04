package com.apostas.infraestructure.rest;

import com.apostas.application.dto.TeamDto;
import com.apostas.application.representation.TeamRepresentation;
import com.apostas.application.services.TeamService;
import com.apostas.domain.game.Team;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    private TeamService teamService;

    @Inject
    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @GET
    @Operation(summary = "Obtém todos os times/concorrentes da base.")
    public List<TeamRepresentation> getAllTeams() {
        return this.teamService.getAllTeams();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um time/concorrente por ID na base.")
    public TeamRepresentation getTeamById(@PathParam("id") Long id) {
        return this.teamService.getTeamById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um time/concorrente na base.")
    public Response addTeam(TeamDto teamDto) {
        Team time = new Team(teamDto);
        if(time != null) {
            this.teamService.addTeam(time);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um time/concorrente na base.")
    public Response updateTeam(@PathParam("id") Long id, TeamDto teamDto) {
        teamDto.setId(id);
        this.teamService.updateTeam(teamDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um time/concorrente na base pelo seu id.")
    public Response deleteTeam(@PathParam("id") Long id) {
        this.teamService.deleteTeam(id);
        return Response.ok().build();
    }
}
