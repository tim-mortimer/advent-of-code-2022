package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplyStacks {
    private static final String INPUT_PATH = "src/main/resources/day5/input.txt";

    private static final Pattern STACK_ITEM_LINE_PATTERN = Pattern.compile("^(\\[[A-Z]\\]\\s*)+$");
    private static final Pattern STACK_NUMBER_LINE_PATTERN = Pattern.compile("^\\s(\\d\\s\\s\\s)*\\d\\s$");
    private static final Pattern INSTRUCTION_LINE_PATTERN = Pattern.compile("^move (\\d+) from (\\d) to (\\d)$");

    public static void main(String[] args) throws IOException {
        Input input = parseInput();
        List<Stack<Character>> stacks = initializeStacks(input.stackNumberLine(), input.stackItemLines);
        followInstructions(stacks, input.instructionLines);
        printTopOfStack(stacks);
    }

    private static void printTopOfStack(List<Stack<Character>> stacks) {
        String output = stacks.stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        System.out.println(output);
    }

    private static void followInstructions(List<Stack<Character>> stacks, List<String> instructionLines) {
        for (String instruction : instructionLines) {
            Matcher matcher = INSTRUCTION_LINE_PATTERN.matcher(instruction);
            if (matcher.find()) {
                int quantityMoved = Integer.parseInt(matcher.group(1));
                int fromStack = Integer.parseInt(matcher.group(2));
                int toStack = Integer.parseInt(matcher.group(3));

                for (int i = 0; i < quantityMoved; i++) {
                    Character poppedCharacter = stacks.get(fromStack - 1).pop();
                    stacks.get(toStack - 1).add(poppedCharacter);
                }
            }
        }
    }

    private static List<Stack<Character>> initializeStacks(String stackNumberLine, List<String> stackItemLines) {
        List<Stack<Character>> stacks = createStacks(stackNumberLine);
        populateStacks(stacks, stackItemLines);
        return stacks;
    }

    private static List<Stack<Character>> createStacks(String stackNumberLine) {
        String[] split = stackNumberLine.trim().split("\s+");
        int numberOfStacks = split.length;
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new Stack<>());
        }
        return stacks;
    }

    private static void populateStacks(List<Stack<Character>> stacks, List<String> stackItemLines) {
        for (int i = stackItemLines.size() - 1; i >= 0; i--) {
            String line = stackItemLines.get(i);
            for (int j = 0; j < line.length(); j += 4) {
                String stackEntry = line.substring(j, j + 3);
                if (!stackEntry.trim().equals("")) {
                    int stackNumber = j / 4;
                    char characterToAdd = stackEntry.substring(1, 2).charAt(0);
                    stacks.get(stackNumber).add(characterToAdd);
                }
            }
        }
    }

    private static Input parseInput() throws IOException {
        List<String> allLines;

        try (Stream<String> lines = Files.lines(Path.of(INPUT_PATH))) {
            allLines = lines.toList();
        }

        List<String> stackItemLines = new ArrayList<>();
        String stackNumberLine = "";
        List<String> instructionLines = new ArrayList<>();

        for (String line : allLines) {
            Matcher stackItemLineMatcher = STACK_ITEM_LINE_PATTERN.matcher(line);
            Matcher stackNumberLineMatcher = STACK_NUMBER_LINE_PATTERN.matcher(line);
            Matcher instructionLineMatcher = INSTRUCTION_LINE_PATTERN.matcher(line);

            if (stackItemLineMatcher.matches()) {
                stackItemLines.add(line);
            }

            if (stackNumberLineMatcher.matches()) {
                stackNumberLine = line;
            }

            if (instructionLineMatcher.matches()) {
                instructionLines.add(line);
            }
        }

        return new Input(stackItemLines, stackNumberLine, instructionLines);
    }

    private record Input(List<String> stackItemLines, String stackNumberLine, List<String> instructionLines) {}
}
