package bxl.formation.demo;

import bxl.formation.demo.models.Person;
import bxl.formation.demo.models.Student;
import bxl.formation.demo.models.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Student("Zaza", "Vanderquack", LocalDate.of(2001, 3, 4)));
        people.add(new Teacher("Della", "Duck", LocalDate.of(1980, 11, 20), "Java"));

        for (Person p: people) {

            if(p instanceof Student) {
                ((Student) p).playGame();
            }

            if(p instanceof Student st) {
                st.playGame();
            }
        }
    }
}