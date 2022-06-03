package exceptions;

import maps.MostOftenElement;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ValidAgeTest {

    @Test
    void checkAge_Valid() throws InvalidAgeException {
        assertEquals("welcome to vote", ValidAge.checkAge(18));

    }

    @Test
    void checkAge_ThrowsException() {
        assertThrows(InvalidAgeException.class, () -> ValidAge.checkAge(17));
    }
}