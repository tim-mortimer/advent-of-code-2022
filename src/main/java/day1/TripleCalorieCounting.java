package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.reverseOrder;

public class TripleCalorieCounting {
    private static final String INPUT_PATH = "src/main/resources/day1/input.txt";

    public static int topThreeCalorieCountSum(List<String> calorieAmounts) {
        List<List<Integer>> allElfCalories = new ArrayList<>();
        List<Integer> currentElfCalories = new ArrayList<>();

        for (String calorieAmount : calorieAmounts) {
            if (calorieAmount.equals("")) {
                allElfCalories.add(currentElfCalories);
                currentElfCalories = new ArrayList<>();
            } else {
                currentElfCalories.add(parseInt(calorieAmount));
            }
        }

        allElfCalories.add(currentElfCalories);

        return allElfCalories.stream()
                .map(elfCalories -> elfCalories.stream().reduce(0, Integer::sum))
                .sorted(reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws IOException {
        List<String> calorieAmounts = readCaloriesList();
        System.out.println(topThreeCalorieCountSum(calorieAmounts));
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
