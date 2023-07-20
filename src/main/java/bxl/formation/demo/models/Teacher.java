package bxl.formation.demo.models;

import java.text.MessageFormat;
import java.time.LocalDate;

public class Teacher extends  Person {

    // Champs
    private String course;

    // Constructeurs
    private void initalize() {
        this.course = course;
    }

    public Teacher(String firstName, String lastName, String course) {
        super(firstName, lastName);
        initalize();
    }

    public Teacher(String firstName, String lastName, LocalDate birthDate, String course) {
        super(firstName, lastName, birthDate);
        initalize();
    }

    // Methodes
    @Override
    public String eats(String meal) {
        return MessageFormat.format("{0} mange {1}", getFullName(), meal);
    }
}
