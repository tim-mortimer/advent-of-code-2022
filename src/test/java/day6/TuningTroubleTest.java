package day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TuningTroubleTest {

    @Test
    void four_distinct_charters_report_4() {
        assertEquals(4, TuningTrouble.diagnose("abcd", 4));
    }

    @Test
    void a_repeat_character_resets_the_counter() {
        assertEquals(5, TuningTrouble.diagnose("aabcd", 4));
        assertEquals(6, TuningTrouble.diagnose("abbcde", 4));
    }

    @Test
    void the_marker_can_be_in_the_middle_of_the_input_string() {
        assertEquals(5, TuningTrouble.diagnose("aabcde", 4));
    }
}
