package dev.kush;

import dev.kush.data.Person;

import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example3 {
    public static void main(String[] args) {
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
