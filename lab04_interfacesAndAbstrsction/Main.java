package lab04_interfacesAndAbstrsction;

import lab04_interfacesAndAbstrsction.sayHello.Bulgarian;
import lab04_interfacesAndAbstrsction.sayHello.Chinese;
import lab04_interfacesAndAbstrsction.sayHello.European;
import lab04_interfacesAndAbstrsction.sayHello.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}

