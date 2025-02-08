package dev.kush.data;

import java.util.List;
import java.util.Set;

public class PersonSet {

    public static Set<Person> people = Set.of(
            new Person("Alice", "Johnson", 34, "New York", List.of("Reading", "Traveling")),
            new Person("Bob", "Smith", 28, "Los Angeles", List.of("Cooking", "Cycling")),
            new Person("Charlie", "Davis", 22, "New York", List.of("Gaming", "Traveling")),
            new Person("Diana", "Evans", 40, "Chicago", List.of("Reading", "Swimming")),
            new Person("Ethan", "Brown", 30, "Los Angeles", List.of("Cycling", "Running")),
            new Person("Fiona", "Clark", 25, "Chicago", List.of("Gaming", "Cooking")),
            new Person("George", "White", 50, "New York", List.of("Fishing", "Photography")),
            new Person("Hannah", "Miller", 37, "Seattle", List.of("Hiking", "Painting")),
            new Person("Isaac", "Moore", 29, "San Francisco", List.of("Cycling", "Gaming")),
            new Person("Jack", "Wilson", 33, "New York", List.of("Running", "Swimming"))
    );
}