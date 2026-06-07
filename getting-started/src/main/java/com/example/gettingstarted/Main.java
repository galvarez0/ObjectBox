package com.example.gettingstarted;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class Main {
    public static void main(String[] args) {
        try (BoxStore store = MyObjectBox.builder()
                .name("person-db")
                .build()) {

            Box<Person> box = store.boxFor(Person.class);

            Person person = new Person("Joe", "Green");
            long id = box.put(person);
            System.out.println("CREATE: " + person);

            person = box.get(id);
            System.out.println("READ:   " + person);

            if (person == null) {
                throw new IllegalStateException("No se pudo recuperar la persona con ID " + id);
            }

            person.setLastName("Black");
            box.put(person);
            System.out.println("UPDATE: " + box.get(id));

            boolean removed = box.remove(person);
            System.out.println("DELETE: eliminado=" + removed);
            System.out.println("READ AFTER DELETE: " + box.get(id));
        }
    }
}
