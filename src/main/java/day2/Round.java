package day2;

import static day2.Outcome.*;

public record Round(Move opponentMove, Move move) {
    public int score() {
        Outcome outcome = calculateOutcome();
        return outcome.score() + move.score();
    }

    private Outcome calculateOutcome() {
        return switch (opponentMove) {
            case ROCK -> {
                yield switch (move) {
                    case ROCK -> Draw;
                    case PAPER -> Win;
                    case SCISSORS -> Lose;
                };
            }
            case PAPER -> {
                yield switch (move) {
                    case ROCK -> Lose;
                    case PAPER -> Draw;
                    case SCISSORS -> Win;
                };
            }
            case SCISSORS -> {
                yield switch (move) {
                    case ROCK -> Win;
                    case PAPER -> Lose;
                    case SCISSORS -> Draw;
                };
            }
        };
    }
}
