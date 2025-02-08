package dev.kush;

import dev.kush.data.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

/**
 * Example8 demonstrates how to sort people by first name and format their names.
 */
public class Example8 {

    /**
     * Formats a list of names into a single string.
     *
     * @param names the list of names
     * @return the formatted names
     */
    private static String formatNames(List<String> names) {
        return switch (names.size()) {
            case 0 -> "";
            case 1 -> names.get(0);
            case 2 -> names.get(0) + " and " + names.get(1);
            default -> String.join(", ", names.subList(0, names.size() - 1))
                    + ", and " + names.getLast();
        };
    }


    public static void main(String[] args) {
        /*
         * Sort people by first name and format their names.
         * The collectingAndThen method in the Collectors class is a static factory method that returns a Collector.
         */
        String formattedNames = people.stream()
                .sorted(Comparator.comparing(Person::firstName)) // Sort by first name
                .map(person -> person.firstName() + " " + person.lastName()) // Convert to full name
                .collect(Collectors.collectingAndThen(Collectors.toList(), names -> formatNames(names)));

        System.out.println("Formatted Names: " + formattedNames);
    }
}
