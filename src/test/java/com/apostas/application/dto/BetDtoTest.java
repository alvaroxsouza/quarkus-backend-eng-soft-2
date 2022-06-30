package com.apostas.application.dto;

import com.apostas.domain.game.Game;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.wildfly.common.Assert.assertFalse;

public class BetDtoTest {
    @Test
    void testEqualsTrueSameObject() {
        BetDto betDto = new BetDto();
        betDto.setBetValue("BRL 2500,00");
        betDto.setCreated_at(LocalDate.now().minusDays(2));
        betDto.setId(123L);
        betDto.setIdUser(321L);
        betDto.setTerminoAposta(LocalDate.now().plusDays(4));
        betDto.setWin(true);
        betDto.setUpdated_at(LocalDate.now());

        List<Long> gameList = new ArrayList<>();
        gameList.add(1L);
        gameList.add(2L);

        betDto.setGames(gameList);

        assertTrue(betDto.equals(betDto));
    }

    @Test
    void testEqualsTrueDifferentObject() {
        BetDto betDto1 = new BetDto();
        BetDto betDto2 = new BetDto();

        String value = "BRL 2500,00";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(4);
        boolean win = true;
        Long betId = 123L;
        Long userId = 321L;
        List<Long> gameList = new ArrayList<>();
        gameList.add(1L);
        gameList.add(2L);

        betDto1.setBetValue(value);
        betDto1.setCreated_at(createdDate);
        betDto1.setUpdated_at(updatedDate);
        betDto1.setTerminoAposta(endDate);
        betDto1.setWin(win);
        betDto1.setId(betId);
        betDto1.setIdUser(userId);
        betDto1.setGames(gameList);

        betDto2.setBetValue(value);
        betDto2.setCreated_at(createdDate);
        betDto2.setUpdated_at(updatedDate);
        betDto2.setTerminoAposta(endDate);
        betDto2.setWin(win);
        betDto2.setId(betId);
        betDto2.setIdUser(userId);
        betDto2.setGames(gameList);

        assertTrue(betDto1.equals(betDto2));
        assertTrue(betDto2.equals(betDto1));
    }


    @Test
    void testEqualsFalseDifferentOneAttributeDifference() {
        BetDto betDto1 = new BetDto();
        BetDto betDto2 = new BetDto();

        String value = "BRL 2500,00";
        LocalDate createdDate = LocalDate.now().minusDays(2);
        LocalDate updatedDate1 = LocalDate.now();
        LocalDate updatedDate2 = LocalDate.now().plusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(4);
        boolean win = true;
        Long betId = 123L;
        Long userId = 321L;
        List<Long> gameList = new ArrayList<>();
        gameList.add(1L);
        gameList.add(2L);

        betDto1.setBetValue(value);
        betDto1.setCreated_at(createdDate);
        betDto1.setUpdated_at(updatedDate1);
        betDto1.setTerminoAposta(endDate);
        betDto1.setWin(win);
        betDto1.setId(betId);
        betDto1.setIdUser(userId);
        betDto1.setGames(gameList);

        betDto2.setBetValue(value);
        betDto2.setCreated_at(createdDate);
        betDto2.setUpdated_at(updatedDate2);
        betDto2.setTerminoAposta(endDate);
        betDto2.setWin(win);
        betDto2.setId(betId);
        betDto2.setIdUser(userId);
        betDto2.setGames(gameList);

        assertFalse(betDto1.equals(betDto2));
        assertFalse(betDto2.equals(betDto1));
    }

    @Test
    void testEqualsFalseMoreThanOneDifference() {
        BetDto betDto1 = new BetDto();
        BetDto betDto2 = new BetDto();

        String value1 = "BRL 2500,00";
        String value2 = "BRL 3500,00";
        LocalDate createdDate1 = LocalDate.now().minusDays(2);
        LocalDate createdDate2 = LocalDate.now().minusDays(1);
        LocalDate updatedDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(4);
        boolean win = true;
        Long betId = 123L;
        Long userId1 = 321L;
        Long userId2 = 654321L;
        List<Long> gameList = new ArrayList<>();
        gameList.add(1L);
        gameList.add(2L);

        betDto1.setBetValue(value1);
        betDto1.setCreated_at(createdDate1);
        betDto1.setUpdated_at(updatedDate);
        betDto1.setTerminoAposta(endDate);
        betDto1.setWin(win);
        betDto1.setId(betId);
        betDto1.setIdUser(userId1);
        betDto1.setGames(gameList);

        betDto2.setBetValue(value2);
        betDto2.setCreated_at(createdDate2);
        betDto2.setUpdated_at(updatedDate);
        betDto2.setTerminoAposta(endDate);
        betDto2.setWin(win);
        betDto2.setId(betId);
        betDto2.setIdUser(userId2);
        betDto2.setGames(gameList);

        assertFalse(betDto1.equals(betDto2));
        assertFalse(betDto2.equals(betDto1));
    }

    @Test
    void testEqualsFalseDifferentTypes() {
        BetDto betDto = new BetDto();
        betDto.setBetValue("BRL 2500,00");
        betDto.setCreated_at(LocalDate.now().minusDays(2));
        betDto.setId(123L);
        betDto.setIdUser(321L);
        betDto.setTerminoAposta(LocalDate.now().plusDays(4));
        betDto.setWin(true);
        betDto.setUpdated_at(LocalDate.now());

        Game game = new Game(1L);

        Assert.assertFalse(betDto.equals(game));
    }
}