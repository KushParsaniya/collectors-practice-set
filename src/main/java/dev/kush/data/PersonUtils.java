package dev.kush.data;

import java.util.List;

/**
 * PersonUtils provides utility methods for working with Person objects.
 */
public class PersonUtils {

    /**
     * Returns a list of first names from a list of people.
     *
     * @param people the list of people
     * @return the list of first names
     */
    public static List<String> getNames(List<Person> people) {
        return people.stream()
                .map(Person::firstName)
                .toList();
    }
}
