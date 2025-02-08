package dev.kush;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

/**
 * Example7 demonstrates how to find the most common hobby among a list of people.
 */
public class Example7 {
    public static void main(String[] args) {
        Map<String, Long> hobbyCounts = people.stream()
                .flatMap(person -> person.hobbies().stream())  // Flatten hobby lists
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences

        /*
         * Find the most common hobby among people.
         * The max method in the Stream class returns an Optional.
         * The orElse method returns the value if present, otherwise returns the default value.
         */
        String mostCommonHobby = hobbyCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // Find max count
                .map(Map.Entry::getKey)
                .orElse("No hobbies found");

        System.out.println("Most Common Hobby: " + mostCommonHobby);
    }
}
