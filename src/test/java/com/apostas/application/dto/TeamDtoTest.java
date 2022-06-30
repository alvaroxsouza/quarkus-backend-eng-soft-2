package com.apostas.application.dto;

import com.apostas.domain.enumutilities.ResultEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.wildfly.common.Assert.assertFalse;

public class TeamDtoTest {
    @Test
    void testEqualsTrueSameObject() {
        TeamDto teamDto = new TeamDto();
        
        teamDto.setId(123L);
        teamDto.setNomeTeam("Bayern Munchen");
        teamDto.setPaisDeOrigem("Alemanha");

        assertTrue(teamDto.equals(teamDto));
    }

    @Test
    void testEqualsTrueDifferentObject() {
        TeamDto teamDto1 = new TeamDto();
        TeamDto teamDto2 = new TeamDto();
        
        teamDto1.setId(123L);
        teamDto1.setNomeTeam("Bayern Munchen");
        teamDto1.setPaisDeOrigem("Alemanha");

        teamDto2.setId(123L);
        teamDto2.setNomeTeam("Bayern Munchen");
        teamDto2.setPaisDeOrigem("Alemanha");
        

        assertTrue(teamDto1.equals(teamDto2));
        assertTrue(teamDto2.equals(teamDto1));
    }

    @Test
    void testEqualsFalseDifferentOneAttributeDifference() {
        TeamDto teamDto1 = new TeamDto();
        TeamDto teamDto2 = new TeamDto();
        
        teamDto1.setId(123L);
        teamDto1.setNomeTeam("Bayern Munchen");
        teamDto1.setPaisDeOrigem("Alemanha");

        teamDto2.setId(123L);
        teamDto2.setNomeTeam("Borussia Dortmund");
        teamDto2.setPaisDeOrigem("Alemanha");

        assertFalse(teamDto1.equals(teamDto2));
        assertFalse(teamDto2.equals(teamDto1));
    }

    @Test
    void testEqualsFalseMoreThanOneDifference() {
        TeamDto teamDto1 = new TeamDto();
        TeamDto teamDto2 = new TeamDto();
        
        teamDto1.setId(123L);
        teamDto1.setNomeTeam("Bayern Munchen");
        teamDto1.setPaisDeOrigem("Alemanha");

        teamDto2.setId(321L);
        teamDto2.setNomeTeam("Manchester United");
        teamDto2.setPaisDeOrigem("Inglaterra");

        assertFalse(teamDto1.equals(teamDto2));
        assertFalse(teamDto2.equals(teamDto1));
    }

    @Test
    void testEqualsFalseDifferentTypes() {
        TeamDto teamDto = new TeamDto();
        
        teamDto.setId(123L);
        teamDto.setNomeTeam("Bayern Munchen");
        teamDto.setPaisDeOrigem("Alemanha");

        BetDto betDto = new BetDto();

        assertFalse(teamDto.equals(betDto));
    }
}
