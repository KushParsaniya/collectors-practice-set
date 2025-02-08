package dev.kush;

import dev.kush.data.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dev.kush.data.PersonSet.people;
import static dev.kush.data.PersonUtils.getNames;

/**
 * Example2 demonstrates how to partition a list of people into two groups based on a predicate.
 */
public class Example2 {
    public static void main(String[] args) {
        /*
         * Partition people into two groups based on a predicate.
         * The partitioningBy method in the Collectors class is a static factory method that returns a Collector.
         * The partitioningBy method takes a Predicate that tests each element in the stream.
         * The partitioningBy method returns a Collector that partitions elements in the stream into two groups based on the Predicate.
         * The two groups are represented as a Map with Boolean keys.
         * The key true represents elements that satisfy the Predicate.
         * The key false represents elements that do not satisfy the Predicate.
         */
        /*
         * groupingBy vs partitioningBy
         * The groupingBy method in the Collectors class groups elements in the stream by a key extracted by a Function.
         * The partitioningBy method in the Collectors class partitions elements in the stream into two groups based on a Predicate.
         */
        Map<Boolean, List<Person>> partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.age() >= 30));

        // Print the people in each group using the getNames utility method
        System.out.println("People aged 30 and above: " + getNames(partitionedByAge.get(true)));
        System.out.println("People below 30: " + getNames(partitionedByAge.get(false)));
    }
}
