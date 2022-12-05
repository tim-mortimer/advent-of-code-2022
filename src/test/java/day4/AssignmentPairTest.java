package day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentPairTest {
    @Test
    void does_not_have_inclusive_range() {
        AssignmentPair pair = AssignmentPair.from("1-4,2-5");
        assertEquals(false, pair.hasInclusiveRange());
    }

    @Test
    void has_inclusive_range() {
        AssignmentPair pair = AssignmentPair.from("1-4,2-3");
        assertEquals(true, pair.hasInclusiveRange());
    }

    @Test
    void does_not_have_overlapping_range() {
        AssignmentPair pair = AssignmentPair.from("1-4,5-8");
        assertEquals(false, pair.hasInclusiveRange());
    }

    @Test
    void has_overlapping_range() {
        AssignmentPair pair = AssignmentPair.from("1-4,3-6");
        assertEquals(true, pair.hasOverlappingAssignment());
    }
}
