package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackReorganisationTest {

    @Test
    void the_unicode_of_A_is_decimal_is_65() {
        assertEquals(65, 'A');
    }

    @Test
    void the_priority_of_A_is_27() {
        assertEquals(27, Priority.of('A').value());
    }

    @Test
    void the_priority_of_Z_is_52() {
        assertEquals(52, Priority.of('Z').value());
    }

    @Test
    void the_priority_of_a_is_1() {
        assertEquals(1, Priority.of('a').value());
    }

    @Test
    void the_priority_of_z_is_26() {
        assertEquals(26, Priority.of('z').value());
    }
}
