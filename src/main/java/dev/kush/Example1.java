package dev.kush;

import dev.kush.data.Person;
import dev.kush.data.PersonUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;
import static dev.kush.data.PersonUtils.getNames;

public class Example1 {
    public static void main(String[] args) {
        Map<String, List<Person>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(Person::city));

        peopleByCity.forEach((city, residents) -> {
            System.out.println(city + ": " + getNames(residents));
        });
    }
}
