import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
    @Nested
    class Constructor {
        @Test
        void exceptionIfParamNull() {
            assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        }

        @Test
        void textExceptionIfParamNull() {
            try {
                new Hippodrome(null);
            } catch (IllegalArgumentException e) {
                assertEquals("Horses cannot be null.", e.getMessage());
            }
        }

        @Test
        void exceptionIfHorsesEmpty() {
            assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        }

        @Test
        void textExceptionIfHorsesEmpty() {
            try {
                new Hippodrome(new ArrayList<>());
            } catch (IllegalArgumentException e) {
                assertEquals("Horses cannot be empty.", e.getMessage());
            }
        }
    }

    @Test
    void getHorses() {
        List<Horse> horses = getHorsesList(30);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
        assertTrue(hippodrome.getHorses().containsAll(horses));
        for (int i = 0; i < 30; i++) {
            assertEquals(horses.get(i), hippodrome.getHorses().get(i));
        }
    }

    @Test
    void allHorsesMove() {
            List<Horse> horses = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                horses.add(mock(Horse.class));
            }
            new Hippodrome(horses).move();
            for (int i = 0; i < 50; i++) {
                Horse horse = horses.get(i);
                verify(horse).move();
            }
    }

    @Test
    void getWinner() {
        List<Horse> horses = getHorsesList(7);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(6, hippodrome.getWinner().getDistance());
    }

    private static List<Horse> getHorsesList (int count) {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            horses.add(getHorse(i));
        }
        return horses;
    }
    private static Horse getHorse(int number) {
        return new Horse("Horse" + number, number, number);
    }
}