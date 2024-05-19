package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonWithParentsNames {
    private Person person;
    private List<String> names;

    public PersonWithParentsNames(Person person,List<String> names) {
        this.person = person;
        this.names = names;
    }

    public static PersonWithParentsNames fromCsvLine(String line){
        Person person =  Person.fromCsvLine(line);
        String[] fields = line.split(",",-1 );
        System.out.println(Arrays.toString(fields));
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (!fields[i + 3].isEmpty()) {
                names.add(fields[i + 3]);
            }
        }
        return new PersonWithParentsNames(person, names);
    }

    public Person getPerson() {
        return this.person;
    }

    static void linkRelatives(Map<String, PersonWithParentsNames> personmap){
        for(PersonWithParentsNames personWithParentNames : personmap.values()){
            for(var parentName : personWithParentNames.names){
                personWithParentNames.person.addParent(personmap.get(parentName).person);
            }
        }
    }

    @Override
    public String toString() {
        return "PersonWithParentsNames{" +
                "person=" + person +
                ", names=" + names +
                '}';
    }
}
