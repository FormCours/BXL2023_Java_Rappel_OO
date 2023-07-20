package bxl.formation.demo.models;

import java.text.MessageFormat;
import java.time.LocalDate;

public abstract class Person {

    // Champs
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    // Constructeurs
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = null;
    }

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this(firstName, lastName);

        this.birthDate = birthDate;
    }

    // Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        // Getters calculer => N'est pas lier à un attribut de la classe
        return MessageFormat.format("{0} {1}", getFirstName(), getLastName());
    }

    // Méthodes
    public abstract String eats(String meal);

    public String sleep() {
        return MessageFormat.format("{0} dort !", getFullName());
    }
}
