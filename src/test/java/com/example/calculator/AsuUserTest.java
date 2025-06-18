package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AsuUserTest {

    @Test
    public void testUserProperties() {
        AsuUserQ3 user = new AsuUserQ3("Nisumite", "nisum@example.com", 22);

        assertAll("AsuUser properties",
                () -> assertEquals("Nisumite", user.getName()),
                () -> assertEquals("nisum@example.com", user.getEmail()),
                () -> assertEquals(22, user.getAge())
        );

        assertTrue(user.getAge() >= 18);
        assertNotNull(user.getEmail());
    }

    @Test
    public void testValidateAgeThrowsException() {
        AsuUserServiceQ3 service = new AsuUserServiceQ3();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validateAge(15);
        });

        assertEquals("Underage", exception.getMessage());
    }
}
