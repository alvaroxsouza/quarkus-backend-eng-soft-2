package com.apostas.application.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.apostas.domain.enumutilities.ProfileUserEnum;

public class UserDtoTest {
    @Test
    void testEqualsTrueSameObject() {
        UserDto userDto = new UserDto();

        userDto.setId(123L);
        userDto.setNomeDoUsuario("caionms");
        userDto.setEmail("caionms@ufba.br");
        userDto.setProfile(ProfileUserEnum.APOSTADOR);
        userDto.setSenha("pass");
        userDto.setCreated_at(LocalDate.now().minusDays(2));
        userDto.setUpdated_at(LocalDate.now());

        assertTrue(userDto.equals(userDto));
    }

    @Test
    void testEqualsTrueDifferentObject() {
        UserDto userDto1 = new UserDto();
        UserDto userDto2 = new UserDto();

        userDto1.setId(123L);
        userDto1.setNomeDoUsuario("caionms");
        userDto1.setEmail("caionms@ufba.br");
        userDto1.setProfile(ProfileUserEnum.APOSTADOR);
        userDto1.setSenha("pass");
        userDto1.setCreated_at(LocalDate.now().minusDays(2));
        userDto1.setUpdated_at(LocalDate.now());
        
        userDto2.setId(123L);
        userDto2.setNomeDoUsuario("caionms");
        userDto2.setEmail("caionms@ufba.br");
        userDto2.setProfile(ProfileUserEnum.APOSTADOR);
        userDto2.setSenha("pass");
        userDto2.setCreated_at(LocalDate.now().minusDays(2));
        userDto2.setUpdated_at(LocalDate.now());

        assertTrue(userDto1.equals(userDto2));
        assertTrue(userDto2.equals(userDto1));
    }

    @Test
    void testEqualsFalseDifferentOneAttributeDifference() {
        UserDto userDto1 = new UserDto();
        UserDto userDto2 = new UserDto();

        userDto1.setId(123L);
        userDto1.setNomeDoUsuario("caionms");
        userDto1.setEmail("caionms@ufba.br");
        userDto1.setProfile(ProfileUserEnum.APOSTADOR);
        userDto1.setSenha("pass");
        userDto1.setCreated_at(LocalDate.now().minusDays(2));
        userDto1.setUpdated_at(LocalDate.now());
        
        userDto2.setId(123L);
        userDto2.setNomeDoUsuario("joaopedro");
        userDto2.setEmail("caionms@ufba.br");
        userDto2.setProfile(ProfileUserEnum.APOSTADOR);
        userDto2.setSenha("pass");
        userDto2.setCreated_at(LocalDate.now().minusDays(2));
        userDto2.setUpdated_at(LocalDate.now());

        assertFalse(userDto1.equals(userDto2));
        assertFalse(userDto2.equals(userDto1));
    }

    @Test
    void testEqualsFalseMoreThanOneDifference() {
        UserDto userDto1 = new UserDto();
        UserDto userDto2 = new UserDto();

        userDto1.setId(123L);
        userDto1.setNomeDoUsuario("caionms");
        userDto1.setEmail("caionms@ufba.br");
        userDto1.setProfile(ProfileUserEnum.APOSTADOR);
        userDto1.setSenha("pass");
        userDto1.setCreated_at(LocalDate.now().minusDays(2));
        userDto1.setUpdated_at(LocalDate.now());
        
        userDto2.setId(123L);
        userDto2.setNomeDoUsuario("joaopedro");
        userDto2.setEmail("joaopedro@ufba.br");
        userDto2.setProfile(ProfileUserEnum.ADMINISTRADOR);
        userDto2.setSenha("password");
        userDto2.setCreated_at(LocalDate.now().minusDays(2));
        userDto2.setUpdated_at(LocalDate.now());

        assertFalse(userDto1.equals(userDto2));
        assertFalse(userDto2.equals(userDto1));
    }

    @Test
    void testEqualsFalseDifferentTypes() {
        UserDto userDto = new UserDto();

        userDto.setId(123L);
        userDto.setNomeDoUsuario("caionms");
        userDto.setEmail("caionms@ufba.br");
        userDto.setProfile(ProfileUserEnum.APOSTADOR);
        userDto.setSenha("pass");
        userDto.setCreated_at(LocalDate.now().minusDays(2));
        userDto.setUpdated_at(LocalDate.now());

        assertTrue(userDto.equals(userDto));

        BetDto betDto = new BetDto();

        assertFalse(userDto.equals(betDto));
    }
}
