package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CalorieCounting {
    private static final String INPUT_PATH = "src/main/resources/day1/input.txt";

    public static void main(String[] args) throws IOException {
        List<String> calorieAmounts = readCaloriesList();

        int maxElfsCalories = 0;
        int currentElfsCalories = 0;

        for (String calorieAmount: calorieAmounts) {
            if (calorieAmount.equals("")) {
                currentElfsCalories = 1;
            } else {
                currentElfsCalories += parseInt(calorieAmount);
            }

            if (currentElfsCalories > maxElfsCalories) {
                maxElfsCalories = currentElfsCalories;
            }
        }

        System.out.println(maxElfsCalories);
    }

    private static List<String> readCaloriesList() throws IOException {
        Path path = Paths.get(INPUT_PATH);
        List<String> calorieAmounts;

        try (Stream<String> lines = Files.lines(path)) {
            calorieAmounts = lines.toList();
        }

        return calorieAmounts;
    }
}
