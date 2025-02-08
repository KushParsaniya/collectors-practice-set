package dev.kush;

import dev.kush.data.Person;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

/**
 * Example4 demonstrates how to group people by city and find the oldest person in each city.
 */
public class Example4 {
    public static void main(String[] args) {
        /*
         * Group people by city and find the oldest person in each city.
         * The maxBy method in the Collectors class is a static factory method that returns a Collector.
         */
        Map<String, Optional<Person>> oldestPersonByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.maxBy(Comparator.comparingInt(Person::age))
                ));

        // Print the oldest person name in each city
        oldestPersonByCity.forEach((city, person) -> {
            System.out.println(city + ": " + person.map(Person::firstName).orElse(""));
        });
    }
}
