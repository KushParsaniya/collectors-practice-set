package dev.kush;

import dev.kush.data.PersonSet;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example7 {
    public static void main(String[] args) {
        Map<String, Long> hobbyCounts = people.stream()
                .flatMap(person -> person.hobbies().stream())  // Flatten hobby lists
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences

        String mostCommonHobby = hobbyCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // Find max count
                .map(Map.Entry::getKey)
                .orElse("No hobbies found");

        System.out.println("Most Common Hobby: " + mostCommonHobby);
    }
}
