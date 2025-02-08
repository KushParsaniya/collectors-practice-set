package dev.kush.data;

import java.util.List;

public record Person(String firstName, String lastName, int age, String city, List<String> hobbies) {}
