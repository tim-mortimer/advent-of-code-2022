package day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static day2.Move.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPaperScissorsTest {

    @Test
    void one_round_i_lose() {
        assertEquals(3, RockPaperScissors.play(List.of(new Round(ROCK, SCISSORS))));
        assertEquals(1, RockPaperScissors.play(List.of(new Round(PAPER, ROCK))));
        assertEquals(2, RockPaperScissors.play(List.of(new Round(SCISSORS, PAPER))));
    }

    @Test
    void one_round_i_win() {
        assertEquals(8, RockPaperScissors.play(List.of(new Round(ROCK, PAPER))));
        assertEquals(9, RockPaperScissors.play(List.of(new Round(PAPER, SCISSORS))));
        assertEquals(7, RockPaperScissors.play(List.of(new Round(SCISSORS, ROCK))));
    }

    @Test
    void one_round_draw() {
        assertEquals(4, RockPaperScissors.play(List.of(new Round(ROCK, ROCK))));
        assertEquals(5, RockPaperScissors.play(List.of(new Round(PAPER, PAPER))));
        assertEquals(6, RockPaperScissors.play(List.of(new Round(SCISSORS, SCISSORS))));
    }

    @Test
    void two_rounds() {
        assertEquals(10, RockPaperScissors.play(List.of(
                new Round(ROCK, SCISSORS),
                new Round(SCISSORS, ROCK))));
    }
}
