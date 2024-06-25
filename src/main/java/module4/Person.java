package module4;

import java.util.Arrays;
import java.util.Comparator;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        Arrays.sort(people, Comparator.comparing(p -> p.name));

        String last;
        int found;

    }

}

