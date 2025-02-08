package dev.kush;

import dev.kush.data.Person;

import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

/**
 * Example6 demonstrates how to group people by city and count the number of unique hobbies in each city.
 */
public class Example6 {
    public static void main(String[] args) {
        /*
         * Group people by city and count the number of unique hobbies in each city.
         * toMap method in the Collectors class is a static factory method that returns a Collector.
         * The toMap method takes two functions:
         * 1. A Function that extracts the key from each element in the stream.
         * 2. A Function that extracts the value from each element in the stream.
         */
        Map<String, Long> uniqueHobbiesCountByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.flatMapping(
                                person -> person.hobbies().stream(),  // Flatten hobbies from each person
                                Collectors.toSet() // Collect unique hobbies
                        )
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (long) entry.getValue().size())); // Count unique hobbies


        uniqueHobbiesCountByCity.forEach((city, count) ->
                System.out.println(city + ": " + count + " unique hobbies")
        );
    }
}
