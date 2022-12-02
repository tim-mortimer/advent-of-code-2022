package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static day2.Move.*;

public class RockPaperScissors {
    private static final String INPUT_PATH = "src/main/resources/day2/input.txt";

    public static int play(List<Round> rounds) {
        return rounds.stream().map(Round::score).mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(INPUT_PATH))) {
            List<Round> rounds = lines.map(round -> {
                        Move opponentsMove = moveFrom(round.charAt(0));
                        Move myMove = counterMoveFrom(opponentsMove, round.charAt(2));
                        return new Round(opponentsMove, myMove);
                    })
                    .toList();

            System.out.println(play(rounds));
        }
    }

    private static Move moveFrom(char move) {
        return switch (move) {
            case 'A', 'X' -> ROCK;
            case 'B', 'Y' -> PAPER;
            case 'C', 'Z' -> SCISSORS;
            default -> throw new IllegalArgumentException("Move must be one of: 'A', 'B', 'C', 'X', 'Y', 'Z'");
        };
    }

    private static Move counterMoveFrom(Move opponentsMove, char myMove) {
        return switch (opponentsMove) {
            case ROCK -> {
                yield switch (myMove) {
                    case 'X' -> SCISSORS;
                    case 'Y' -> ROCK;
                    case 'Z' -> PAPER;
                    default -> throw new IllegalArgumentException("Move must be one of 'X', 'Y', 'Z'");
                };
            }
            case PAPER -> {
                yield switch (myMove) {
                    case 'X' -> ROCK;
                    case 'Y' -> PAPER;
                    case 'Z' -> SCISSORS;
                    default -> throw new IllegalArgumentException("Move must be one of 'X', 'Y', 'Z'");
                };
            }
            case SCISSORS -> {
                yield switch (myMove) {
                    case 'X' -> PAPER;
                    case 'Y' -> SCISSORS;
                    case 'Z' -> ROCK;
                    default -> throw new IllegalArgumentException("Move must be one of 'X', 'Y', 'Z'");
                };
            }
        };
    }
}
