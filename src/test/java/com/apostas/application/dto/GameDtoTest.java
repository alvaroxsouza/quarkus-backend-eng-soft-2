package com.apostas.application.dto;

import com.apostas.domain.enumutilities.ResultEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.wildfly.common.Assert.assertFalse;

public class GameDtoTest {
    @Test
    void testEqualsTrueSameObject() {
        GameDto gameDto = new GameDto();

        Long gameId = 123L;
        Long idTeamHome = 1L;
        Long idTeamAway = 2L;
        ResultEnum resultBet = ResultEnum.GANHADOR_CASA;
        double oddTeamHome = 2.3;
        double oddTeamAway = 1.2;
        double oddTie = 2.0;
        String campeonato = "Alemão";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate = LocalDate.now();
        LocalDate limitDate = LocalDate.now().plusDays(2);
        LocalDate endDate = LocalDate.now().plusDays(4);

        gameDto.setId(gameId);
        gameDto.setIdTeamHome(idTeamHome);
        gameDto.setIdTeamAway(idTeamAway);
        gameDto.setResultBet(resultBet);
        gameDto.setOddTeamHome(oddTeamHome);
        gameDto.setOddTeamAway(oddTeamAway);
        gameDto.setOddTie(oddTie);
        gameDto.setCampeonato(campeonato);
        gameDto.setCreated_at(createdDate);
        gameDto.setUpdated_at(updatedDate);
        gameDto.setLimiteAposta(limitDate);
        gameDto.setDataTermino(endDate);

        assertTrue(gameDto.equals(gameDto));
    }

    @Test
    void testEqualsTrueDifferentObject() {
        GameDto gameDto1 = new GameDto();
        GameDto gameDto2 = new GameDto();

        Long gameId = 123L;
        Long idTeamHome = 1L;
        Long idTeamAway = 2L;
        ResultEnum resultBet = ResultEnum.GANHADOR_CASA;
        double oddTeamHome = 2.3;
        double oddTeamAway = 1.2;
        double oddTie = 2.0;
        String campeonato = "Alemão";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate = LocalDate.now();
        LocalDate limitDate = LocalDate.now().plusDays(2);
        LocalDate endDate = LocalDate.now().plusDays(4);

        gameDto1.setId(gameId);
        gameDto1.setIdTeamHome(idTeamHome);
        gameDto1.setIdTeamAway(idTeamAway);
        gameDto1.setResultBet(resultBet);
        gameDto1.setOddTeamHome(oddTeamHome);
        gameDto1.setOddTeamAway(oddTeamAway);
        gameDto1.setOddTie(oddTie);
        gameDto1.setCampeonato(campeonato);
        gameDto1.setCreated_at(createdDate);
        gameDto1.setUpdated_at(updatedDate);
        gameDto1.setLimiteAposta(limitDate);
        gameDto1.setDataTermino(endDate);

        gameDto2.setId(gameId);
        gameDto2.setIdTeamHome(idTeamHome);
        gameDto2.setIdTeamAway(idTeamAway);
        gameDto2.setResultBet(resultBet);
        gameDto2.setOddTeamHome(oddTeamHome);
        gameDto2.setOddTeamAway(oddTeamAway);
        gameDto2.setOddTie(oddTie);
        gameDto2.setCampeonato(campeonato);
        gameDto2.setCreated_at(createdDate);
        gameDto2.setUpdated_at(updatedDate);
        gameDto2.setLimiteAposta(limitDate);
        gameDto2.setDataTermino(endDate);

        assertTrue(gameDto1.equals(gameDto2));
        assertTrue(gameDto2.equals(gameDto1));
    }

    @Test
    void testEqualsFalseDifferentOneAttributeDifference() {
        GameDto gameDto1 = new GameDto();
        GameDto gameDto2 = new GameDto();

        Long gameId = 123L;
        Long idTeamHome = 1L;
        Long idTeamAway = 2L;
        ResultEnum resultBet = ResultEnum.GANHADOR_CASA;
        double oddTeamHome1 = 2.3;
        double oddTeamHome2 = 5.8;
        double oddTeamAway = 1.2;
        double oddTie = 2.0;
        String campeonato = "Alemão";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate = LocalDate.now();
        LocalDate limitDate = LocalDate.now().plusDays(2);
        LocalDate endDate = LocalDate.now().plusDays(4);

        gameDto1.setId(gameId);
        gameDto1.setIdTeamHome(idTeamHome);
        gameDto1.setIdTeamAway(idTeamAway);
        gameDto1.setResultBet(resultBet);
        gameDto1.setOddTeamHome(oddTeamHome1);
        gameDto1.setOddTeamAway(oddTeamAway);
        gameDto1.setOddTie(oddTie);
        gameDto1.setCampeonato(campeonato);
        gameDto1.setCreated_at(createdDate);
        gameDto1.setUpdated_at(updatedDate);
        gameDto1.setLimiteAposta(limitDate);
        gameDto1.setDataTermino(endDate);

        gameDto2.setId(gameId);
        gameDto2.setIdTeamHome(idTeamHome);
        gameDto2.setIdTeamAway(idTeamAway);
        gameDto2.setResultBet(resultBet);
        gameDto2.setOddTeamHome(oddTeamHome2);
        gameDto2.setOddTeamAway(oddTeamAway);
        gameDto2.setOddTie(oddTie);
        gameDto2.setCampeonato(campeonato);
        gameDto2.setCreated_at(createdDate);
        gameDto2.setUpdated_at(updatedDate);
        gameDto2.setLimiteAposta(limitDate);
        gameDto2.setDataTermino(endDate);

        assertFalse(gameDto1.equals(gameDto2));
        assertFalse(gameDto2.equals(gameDto1));
    }

    @Test
    void testEqualsFalseMoreThanOneDifference() {
        GameDto gameDto1 = new GameDto();
        GameDto gameDto2 = new GameDto();

        Long gameId = 123L;
        Long idTeamHome = 1L;
        Long idTeamAway = 2L;
        ResultEnum resultBet = ResultEnum.GANHADOR_CASA;
        double oddTeamHome1 = 2.3;
        double oddTeamHome2 = 5.8;
        double oddTeamAway = 1.2;
        double oddTie1 = 2.0;
        double oddTie2 = 4.0;
        String campeonato = "Alemão";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate1 = LocalDate.now();
        LocalDate updatedDate2 = LocalDate.now().plusDays(1);
        LocalDate limitDate = LocalDate.now().plusDays(2);
        LocalDate endDate = LocalDate.now().plusDays(4);

        gameDto1.setId(gameId);
        gameDto1.setIdTeamHome(idTeamHome);
        gameDto1.setIdTeamAway(idTeamAway);
        gameDto1.setResultBet(resultBet);
        gameDto1.setOddTeamHome(oddTeamHome1);
        gameDto1.setOddTeamAway(oddTeamAway);
        gameDto1.setOddTie(oddTie1);
        gameDto1.setCampeonato(campeonato);
        gameDto1.setCreated_at(createdDate);
        gameDto1.setUpdated_at(updatedDate1);
        gameDto1.setLimiteAposta(limitDate);
        gameDto1.setDataTermino(endDate);

        gameDto2.setId(gameId);
        gameDto2.setIdTeamHome(idTeamHome);
        gameDto2.setIdTeamAway(idTeamAway);
        gameDto2.setResultBet(resultBet);
        gameDto2.setOddTeamHome(oddTeamHome2);
        gameDto2.setOddTeamAway(oddTeamAway);
        gameDto2.setOddTie(oddTie2);
        gameDto2.setCampeonato(campeonato);
        gameDto2.setCreated_at(createdDate);
        gameDto2.setUpdated_at(updatedDate2);
        gameDto2.setLimiteAposta(limitDate);
        gameDto2.setDataTermino(endDate);

        assertFalse(gameDto1.equals(gameDto2));
        assertFalse(gameDto2.equals(gameDto1));
    }

    @Test
    void testEqualsFalseDifferentTypes() {
        GameDto gameDto = new GameDto();

        Long gameId = 123L;
        Long idTeamHome = 1L;
        Long idTeamAway = 2L;
        ResultEnum resultBet = ResultEnum.GANHADOR_CASA;
        double oddTeamHome = 2.3;
        double oddTeamAway = 1.2;
        double oddTie = 2.0;
        String campeonato = "Alemão";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate = LocalDate.now();
        LocalDate limitDate = LocalDate.now().plusDays(2);
        LocalDate endDate = LocalDate.now().plusDays(4);

        gameDto.setId(gameId);
        gameDto.setIdTeamHome(idTeamHome);
        gameDto.setIdTeamAway(idTeamAway);
        gameDto.setResultBet(resultBet);
        gameDto.setOddTeamHome(oddTeamHome);
        gameDto.setOddTeamAway(oddTeamAway);
        gameDto.setOddTie(oddTie);
        gameDto.setCampeonato(campeonato);
        gameDto.setCreated_at(createdDate);
        gameDto.setUpdated_at(updatedDate);
        gameDto.setLimiteAposta(limitDate);
        gameDto.setDataTermino(endDate);

        BetDto betDto = new BetDto();

        assertFalse(gameDto.equals(betDto));
    }
}
