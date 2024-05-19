package org.example;

public class AmbiguousPersonException extends Exception {
    public AmbiguousPersonException(Person person) {
        super("More then one person with name: " + person.getName());
    }
}