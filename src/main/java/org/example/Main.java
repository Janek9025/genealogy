package org.example;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Person.fromCsv("family.csv");

        people.stream()
                .map(person -> person.getName());
        PlantUMLRunner.setPlantUMLPath("./plantuml-1.2024.4.jar");

        List<Person> people1 = Person.sortByBirthDate(people);

//        List<Person> deadPeople = Person.sortDeadByLifespan(people);
//
//
//        deadPeople.stream().map(person->person.getBirthDate().toEpochDay()-person.getDeathDate().toEpochDay() )
//                .collect(Collectors.toList()).forEach(System.out::println);

        Function<String, String> colorYellow = s -> s.contains("object") ? s.trim() + " #Yellow \n" : s;


        Predicate<Person> hasNameStartingWith = person -> person.getName().contains("Kowalsk");

        PlantUMLRunner.generateDiagram(Person.generateTree(people, colorYellow, hasNameStartingWith), "./", "Parse");

        people1.forEach(System.out::println);

    }
}