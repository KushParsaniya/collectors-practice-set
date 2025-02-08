package dev.kush.data;

import java.util.List;

public class PersonUtils {

    public static List<String> getNames(List<Person> people) {
        return people.stream()
                .map(Person::firstName)
                .toList();
    }
}
