package dev.kush;

import dev.kush.data.Person;

import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

/**
 * Example3 demonstrates how to group people by city and count the number of people in each city.
 */
public class Example3 {
    public static void main(String[] args) {
        /*
         * Group people by city and count the number of people in each city.
         * The counting method in the Collectors class is a static factory method that returns a Collector.
         */
        Map<String, Long> cityCounts = people.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.counting()
                ));

        cityCounts.forEach((city, count) -> {
            System.out.println(city + ": " + count);
        });
    }
}
