package dev.kush;

import dev.kush.data.Person;

import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example6 {
    public static void main(String[] args) {
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
