package com.example.FunctionalProgramming.Stream;

import com.example.FunctionalProgramming.Model.Gender;
import com.example.FunctionalProgramming.Model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.FunctionalProgramming.Model.Gender.FEMALE;
import static com.example.FunctionalProgramming.Model.Gender.MALE;

public class Stream {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Martin Fowler", MALE),
                new Person("Kent Back", MALE),
                new Person("Teresa", FEMALE),
                new Person("Rakhi", FEMALE),
                new Person("Uncle Bob", MALE)
        );

        persons.stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Map<Gender, List<Person>> genders = persons.stream().collect(Collectors.groupingBy(Person::getGender));
        genders.forEach(((gender, people) -> {
            System.out.println(gender);
            people.forEach(
                    System.out::println);
            System.out.println();
        }));
    }
}
