package bxl.formation.demo.models;

import java.security.SecureRandom;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Random;

public class Student extends Person{

    // Champs
    private Random rng;

    // Constructeurs
    public Student(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        rng = new SecureRandom();
    }

    // Méthodes
    @Override
    public String eats(String meal) {
        if(rng.nextBoolean()) {
            return MessageFormat.format("{0} mange {1}", getFullName(), meal);
        }
        return MessageFormat.format("{0} passe au fast food 🍔", getFullName());
    }

    public String playGame() {
        int nbHour = rng.nextInt(3, 8);
        return MessageFormat.format("{0} joue durant {1}", getFullName(), nbHour);
    }

    @Override
    public String sleep() {
        String game = playGame();
        return game + "\n" + super.sleep();
    }
}
