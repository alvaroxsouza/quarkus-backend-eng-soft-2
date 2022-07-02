package com.apostas.infraestructure.rest;

import com.apostas.application.dto.FoundMoneyDto;
import com.apostas.application.dto.LoginDto;
import com.apostas.application.dto.UserDto;
import com.apostas.application.representation.UserRepresentation;
import com.apostas.application.services.UserService;
import com.apostas.domain.user.User;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Operation(summary = "Obtém todos os usuários da base.")
    public List<UserRepresentation> getAllUser() {
        return this.userService.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Obtém um usuário por ID na base.")
    public UserRepresentation getUserById(@PathParam("id") Long id) {
        return this.userService.getUserById(id);
    }

    @POST
    @Transactional
    @Operation(summary = "Adiciona um usuário na base.")
    public Response addUser(UserDto userDto) {
        User user = new User(userDto);
        if(user != null) {
            this.userService.addUser(user);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "Atualiza um usuário na base.")
    public Response updateUser(@PathParam("id") Long id, UserDto userDto) {
        userDto.setId(id);
        this.userService.updateUser(userDto);
        return Response.ok().build();
    }

    @PATCH
    @Path("add-money")
    @Transactional
    @Operation(summary = "Adiciona fundos a carteira do Usuário")
    public Response addFoundsUser(FoundMoneyDto foundMoneyDto) {
        this.userService.addMoneyUser(foundMoneyDto);
        return Response.ok().build();
    }

    @PATCH
    @Path("withdraw-money")
    @Transactional
    @Operation(summary = "Saca fundos a carteira do Usuário")
    public Response withdrawFoundsUser(FoundMoneyDto foundMoneyDto) {
        this.userService.withdrawMoneyUser(foundMoneyDto);
        return Response.ok().build();
    }

    @POST
    @Path("login")
    @Operation(summary = "Faz login na aplicação")
    public UserRepresentation loginUser(LoginDto loginDto) {
        return this.userService.login(loginDto);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um usuário na base.")
    public Response deleteUser(@PathParam("id") Long id) {
        this.userService.deleteUser(id);
        return Response.ok().build();
    }
}
