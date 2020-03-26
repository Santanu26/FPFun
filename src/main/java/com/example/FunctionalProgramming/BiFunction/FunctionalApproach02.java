package com.example.FunctionalProgramming.BiFunction;

import com.example.FunctionalProgramming.Model.Person;

import java.util.Arrays;
import java.util.List;

import static com.example.FunctionalProgramming.Model.Gender.FEMALE;
import static com.example.FunctionalProgramming.Model.Gender.MALE;
import static java.util.stream.Collectors.toList;

public class FunctionalApproach02 {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Martin Fowler", MALE),
                new Person("Kent Back", MALE),
                new Person("Teresa", FEMALE),
                new Person("Rakhi", FEMALE),
                new Person("Uncle Bob", MALE)
        );

        persons.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .collect(toList())
                .forEach(System.out::println);
    }
}
