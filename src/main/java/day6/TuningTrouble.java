package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class TuningTrouble {
    private static final String INPUT_PATH = "src/main/resources/day6/input.txt";

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(INPUT_PATH));
        System.out.println(diagnose(input, 4));
        System.out.println(diagnose(input, 14));
    }

    public static int diagnose(String input, int markerLength) {
        char[] chars = input.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        int markerPosition = 0;

        for (char character : chars) {
            markerPosition++;

            if (characterSet.contains(character)) {
                characterSet.clear();
            }

            characterSet.add(character);

            if (characterSet.size() == markerLength) {
                return markerPosition;
            }
        }

        return markerPosition;
    }
}
