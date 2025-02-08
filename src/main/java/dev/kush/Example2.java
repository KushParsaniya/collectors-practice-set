package dev.kush;

import dev.kush.data.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;
import static dev.kush.data.PersonUtils.getNames;

public class Example2 {
    public static void main(String[] args) {
        Map<Boolean, List<Person>> partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.age() >= 30));

        System.out.println("People aged 30 and above: " + getNames(partitionedByAge.get(true)));
        System.out.println("People below 30: " + getNames(partitionedByAge.get(false)));
    }
}
