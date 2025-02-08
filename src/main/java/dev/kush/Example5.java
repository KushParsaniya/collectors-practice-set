package dev.kush;

import java.util.Set;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;

public class Example5 {
    public static void main(String[] args) {
        Set<String> uniqueHobbies = people.stream()
                .flatMap(person -> person.hobbies().stream())
                .collect(Collectors.toSet());

        System.out.println("Unique Hobbies: " + uniqueHobbies);
    }
}
