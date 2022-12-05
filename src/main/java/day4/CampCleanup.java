package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class CampCleanup {
    private static final String INPUT_PATH = "src/main/resources/day4/input.txt";

    public static void main(String[] args) throws IOException {
        List<String> inputLines;
        try (Stream<String> lines = Files.lines(Path.of(INPUT_PATH))) {
            inputLines = lines.toList();
        }

        long inclusiveAssignmentCount = inputLines.stream()
                .map(AssignmentPair::from)
                .filter(AssignmentPair::hasInclusiveRange)
                .count();

        System.out.println(inclusiveAssignmentCount);

        long overlappingAssignmentCount = inputLines.stream()
                .map(AssignmentPair::from)
                .filter(AssignmentPair::hasOverlappingAssignment)
                .count();

        System.out.println(overlappingAssignmentCount);
    }
}