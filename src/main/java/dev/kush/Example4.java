package dev.kush;

import dev.kush.data.Person;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example4 {
    public static void main(String[] args) {
        Map<String, Optional<Person>> oldestPersonByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        Collectors.maxBy(Comparator.comparingInt(Person::age))
                ));

        oldestPersonByCity.forEach((city, person) -> {
            System.out.println(city + ": " + person.map(Person::firstName).orElse(""));
        });
    }
}
