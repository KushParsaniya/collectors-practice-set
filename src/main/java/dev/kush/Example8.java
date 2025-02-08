package dev.kush;

import dev.kush.data.Person;
import dev.kush.data.PersonSet;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example8 {

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
        String formattedNames = people.stream()
                .sorted(Comparator.comparing(Person::firstName)) // Sort by first name
                .map(person -> person.firstName() + " " + person.lastName()) // Convert to full name
                .collect(Collectors.collectingAndThen(Collectors.toList(), names -> formatNames(names)));

        System.out.println("Formatted Names: " + formattedNames);
    }
}
