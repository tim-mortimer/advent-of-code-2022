package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class RucksackReorganisation {
    private static final String INPUT_PATH = "src/main/resources/day3/input.txt";

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(INPUT_PATH))) {
            int result = lines.map(line -> {
                        char[] chars = line.toCharArray();
                        int length = chars.length;
                        char[] leftChars = Arrays.copyOfRange(chars, 0, length / 2);
                        char[] rightChars = Arrays.copyOfRange(chars, length / 2, length);
                        Set<Character> leftCharacters = new HashSet<>();
                        Set<Character> rightCharacters = new HashSet<>();
                        for (char character : leftChars) {
                            leftCharacters.add(character);
                        }
                        for (char character : rightChars) {
                            rightCharacters.add(character);
                        }
                        return new Pair(leftCharacters, rightCharacters);
                    })
                    .map(Pair::findDuplicateCharacter)
                    .map(Priority::of)
                    .map(Priority::value)
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println(result);
        }

        try (Stream<String> lines = Files.lines(Path.of(INPUT_PATH))) {
            List<String> stringList = lines.toList();
            List<List<String>> stringGroups = new ArrayList<>();
            List<String> stringGroup = new ArrayList<>();

            for (int i = 0; i < stringList.size(); i++) {
                if (i != 0 && i % 3 == 0) {
                    stringGroups.add(new ArrayList<>(stringGroup));
                    stringGroup = new ArrayList<>();
                }

                stringGroup.add(stringList.get(i));
            }
            stringGroups.add(stringGroup);

            int result2 = stringGroups.stream()
                    .map(group -> group.stream()
                            .map(str -> str.toCharArray())
                            .map(charArray -> {
                                Set<Character> charSet = new HashSet<>();
                                for (char character : charArray) {
                                    charSet.add(character);
                                }
                                return charSet;
                            })
                            .toList())
                    .map(setList -> {
                        setList.get(0).retainAll(setList.get(1));
                        setList.get(0).retainAll(setList.get(2));
                        return setList.get(0);
                    })
                    .map(setList -> setList.stream().toList().get(0))
                    .map(Priority::of)
                    .map(Priority::value)
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println(result2);
        }
    }

    public record Pair(Set<Character> leftCompartment, Set<Character> rightCompartment) {
        public Character findDuplicateCharacter() {
            leftCompartment.retainAll(rightCompartment);
            return leftCompartment.stream().limit(1).toList().get(0);
        }
    }
}
