package dev.kush.data;

import java.util.List;

/**
 * Represents a person with a first name, last name, age, city, and hobbies.
 *
 * @param firstName
 * @param lastName
 * @param age
 * @param city
 * @param hobbies
 */
public record Person(String firstName, String lastName, int age, String city, List<String> hobbies) {
}
