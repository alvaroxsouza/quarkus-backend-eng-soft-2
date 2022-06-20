package com.apostas.infraestructure.validation;

import com.apostas.domain.game.rival.Rival;
import com.apostas.domain.repository.UserRepository;
import com.apostas.infraestructure.exception.BetBussinessExceptions;
import com.apostas.infraestructure.messages.Messages;
import io.quarkus.test.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ValidationTest {

    private Rival rival;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception {
        this.rival = new Rival();
        this.rival.setId(1L);
        this.rival.setNomeRival("Bahia");
        this.rival.setPaisDeOrigem("Brasil");
    }

    @Test
    void notNullSuccessTest() {
        assertDoesNotThrow(() -> Validation.notNull(this.rival.getNomeRival(), "nome"));
    }

    @Test
    void notNullErrorTest() {
        this.rival.setNomeRival(null);
        assertThrowsExactly(BetBussinessExceptions.class,
                () -> Validation.notNull(this.rival.getNomeRival(), "nome"),
                Messages.get("nullvalue", "nome"));
    }

}
