package dev.kush;

import dev.kush.data.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;
import static dev.kush.data.PersonUtils.getNames;

/**
 * Example1 demonstrates how to group people by city.
 */
public class Example1 {
    public static void main(String[] args) {
        /*
         * Group people by city.
         * The groupingBy method in the Collectors class is a static factory method that returns a Collector.
         * The groupingBy method takes a Function that extracts the key from each element in the stream.
         * The groupingBy method returns a Collector that groups elements in the stream by the key extracted by the Function.
         */
        Map<String, List<Person>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(Person::city));

        // Print the people in each city using the getNames utility method
        peopleByCity.forEach((city, residents) -> {
            System.out.println(city + ": " + getNames(residents));
        });
    }
}
