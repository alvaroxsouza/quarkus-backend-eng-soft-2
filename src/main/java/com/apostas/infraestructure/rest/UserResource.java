package com.apostas.infraestructure.rest;

import com.apostas.application.services.UserService;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;
import com.apostas.application.dto.UserDto;
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
    private UserRepository userRepository;

    @Inject
    public UserResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GET
    public List<User> getUser() {
        return this.userService.getAllUsers();
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

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "Deleta um usuário na base.")
    public Response deleteUser(@PathParam("id") Long id) {
        this.userService.deleteUser(id);
        return Response.ok().build();
    }
}