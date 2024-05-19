package org.example;

public class NegativeLifespanException extends Exception{
    public NegativeLifespanException(Person person){
        super("Person " +person.getName() +
                " born in  " +
                person.getBirthDate()+
                " and died in "+
                person.getDeathDate() +
                " Died before birth date !!");
    }

}
