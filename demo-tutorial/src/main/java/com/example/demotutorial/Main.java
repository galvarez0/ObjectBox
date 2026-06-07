package com.example.demotutorial;

import io.objectbox.Box;
import io.objectbox.query.Query;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (ObjectBox objectBox = new ObjectBox()) {
            Box<Note> notesBox = objectBox.getBoxStore().boxFor(Note.class);

            notesBox.removeAll();

            Note first = new Note(
                    "Aprender ObjectBox",
                    "Primera nota del tutorial",
                    new Date()
            );
            notesBox.put(first);
            System.out.println("INSERT: " + first);

            Note second = new Note(
                    "Probar consultas",
                    "La consulta se ordena por fecha descendente",
                    new Date(System.currentTimeMillis() + 1000)
            );
            notesBox.put(second);
            System.out.println("INSERT: " + second);

            try (Query<Note> query = notesBox.query()
                    .orderDesc(Note_.date)
                    .build()) {
                List<Note> notes = query.find();
                System.out.println("\nQUERY: notas ordenadas por fecha descendente");
                notes.forEach(System.out::println);
            }

            first.setComment("Comentario actualizado");
            notesBox.put(first);
            System.out.println("\nUPDATE: " + notesBox.get(first.getId()));

            boolean removed = notesBox.remove(second);
            System.out.println("DELETE: eliminado=" + removed + ", id=" + second.getId());

            System.out.println("\nFINAL: quedan " + notesBox.count() + " nota(s)");
            notesBox.getAll().forEach(System.out::println);
        }
    }
}
