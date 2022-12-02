package day1;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleCalorieCountingTest {
    @Test
    void no_elves() {
        assertEquals(0, TripleCalorieCounting.topThreeCalorieCountSum(Collections.emptyList()));
    }

    @Test
    void one_elf_one_calorie_entry() {
        assertEquals(10, TripleCalorieCounting.topThreeCalorieCountSum(List.of("10")));
    }

    @Test
    void one_elf_two_calorie_entries() {
        assertEquals(30, TripleCalorieCounting.topThreeCalorieCountSum(List.of("10", "20")));
    }

    @Test
    void three_elves_each_with_multiple_calorie_entries() {
        assertEquals(36, TripleCalorieCounting.topThreeCalorieCountSum(List.of(
                "10",
                "1",
                "",
                "10",
                "2",
                "",
                "10",
                "3"
        )));
    }

    @Test
    void four_elves_each_with_multiple_calorie_entries() {
        assertEquals(39, TripleCalorieCounting.topThreeCalorieCountSum(List.of(
                "10",
                "4",
                "",
                "10",
                "1",
                "",
                "10",
                "2",
                "",
                "10",
                "3"
        )));
    }
}
