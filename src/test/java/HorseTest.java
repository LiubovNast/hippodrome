import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HorseTest {
    @Nested
    class Constructor {
        @Test
        void exceptionIfFirstParamNull() {
            assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1.1));
        }

        @Test
        void textExceptionIfFirstParamNull() {
            try {
                new Horse(null, 1.1);
            } catch (IllegalArgumentException e) {
                assertEquals("Name cannot be null.", e.getMessage());
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "      "})
        void exceptionIfFirstParamBlank(String name) {
            assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1.1));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "      "})
        void textExceptionIfFirstParamBlank(String name) {
            try {
                new Horse(name, 1.1);
            } catch (IllegalArgumentException e) {
                assertEquals("Name cannot be blank.", e.getMessage());
            }
        }

        @Test
        void exceptionIfSecondParamNegative() {
            assertThrows(IllegalArgumentException.class, () -> new Horse("horse", -1.1));
        }

        @Test
        void textExceptionIfSecondParamNegative() {
            try {
                new Horse("horse", -1.1);
            } catch (IllegalArgumentException e) {
                assertEquals("Speed cannot be negative.", e.getMessage());
            }
        }

        @Test
        void exceptionIfThirdParamNegative() {
            assertThrows(IllegalArgumentException.class, () -> new Horse("horse", 1.1, -5));
        }

        @Test
        void textExceptionIfThirdParamNegative() {
            try {
                new Horse("horse", 1.1, -5);
            } catch (IllegalArgumentException e) {
                assertEquals("Distance cannot be negative.", e.getMessage());
            }
        }
    }

    @Test
    void getName() {
        Horse horse = new Horse("Jack", 1.2);
        assertEquals("Jack", horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("Jack", 1.2);
        assertEquals(1.2, horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("Black", 1.2, 5);
        assertEquals(5, horse.getDistance());
    }

    @Test
    void getDistanceZero() {
        Horse horse = new Horse("Jack", 1.2);
        assertEquals(0, horse.getDistance());
    }

    @Test
    void moveUseGetRandomDouble() {

        try(MockedStatic<Horse> horseMocked = Mockito.mockStatic(Horse.class)) {
//            horseMocked.when(() -> Horse.getRandomDouble (0.2, 0.9)).thenReturn(0.5);
//            new Horse("1", 1).move();
        }
    }
    @Test
    void getRandomDouble() {
    }
}