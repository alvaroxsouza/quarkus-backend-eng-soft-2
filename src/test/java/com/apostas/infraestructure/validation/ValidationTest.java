package com.apostas.infraestructure.validation;

import com.apostas.domain.game.Team;
import com.apostas.domain.repository.UserRepository;
import com.apostas.infraestructure.exception.BetBussinessExceptions;
import com.apostas.infraestructure.messages.Messages;
import io.quarkus.test.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class ValidationTest {

    private Team team;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception {
        this.team = new Team();
        this.team.setId(1L);
        this.team.setNomeTeam("Bahia");
        this.team.setPaisDeOrigem("Brasil");
    }

    @Test
    void notNullSuccessTest() {
        assertDoesNotThrow(() -> Validation.notNull(this.team.getNomeTeam(), "nome"));
    }

    @Test
    void notNullErrorTest() {
        this.team.setNomeTeam(null);
        assertThrowsExactly(BetBussinessExceptions.class,
                () -> Validation.notNull(this.team.getNomeTeam(), "nome"),
                Messages.get("nullvalue", "nome"));
    }

}
