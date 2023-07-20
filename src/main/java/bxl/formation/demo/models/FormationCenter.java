package bxl.formation.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class FormationCenter {

    // Constantes (Constants)
    public final LocalTime MIN_OPEN_TIME = LocalTime.of(5, 0);
    public final LocalTime MAX_CLOSE_TIME = LocalTime.of(21, 0);

    // Champs (Fields)
    private String name;
    private String address; // TODO Remplace by classe Address
    private LocalTime openTime;
    private LocalTime closeTime;
    private HashMap<String, TrainingPath> trainings;


    // Constructeurs (Constructors)
    public FormationCenter(String name, String address, LocalTime openTime, LocalTime closeTime) {
        if (name == null || name.trim().isEmpty()  /* || name.trim().length() == 0 */) {
            throw new RuntimeException("Le nom du centre de formateur ne peut pas etre vide !");
        }
        if (openTime.isBefore(MIN_OPEN_TIME) || closeTime.isAfter(MAX_CLOSE_TIME)) {
            throw new RuntimeException("L'horraire n'est pas valide !");
        }

        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        trainings = new HashMap<>();
    }

    // Accesseurs (Getters)
    public String getName() {
        return name.toUpperCase();
    }

    public String getAddress() {
        return address;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public TrainingPath getTraining(String trainingCode) {
        if (trainingCode == null || trainingCode.isBlank()) {
            throw new IllegalArgumentException("trainingCode cannot be \"null\" or empty");
        }

        return trainings.get(trainingCode);
    }

    public List<TrainingPath> getTrainings() {
        return List.copyOf(trainings.values());
    }

    // Mutateurs (Setters)
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()  /* || name.trim().length() == 0 */) {
            throw new RuntimeException("Le nom du centre de formateur ne peut pas etre vide !");
        }
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenTime(LocalTime openTime) {
        if (openTime != null && openTime.isBefore(MIN_OPEN_TIME)) {
            this.openTime = MIN_OPEN_TIME;
            return;
        }

        this.openTime = openTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        // Si closeTime n'est pas null et après MAX_CLOSE_TIME alors la valeur est MAX_CLOSE_TIME sinon c'est closeTime
        this.closeTime = (closeTime != null && closeTime.isAfter(MAX_CLOSE_TIME)) ? MAX_CLOSE_TIME : closeTime;
    }


    // Méthodes (Method)
    public Boolean addTraining(String code, String name, int nbStudent, LocalDate startDate, LocalDate endDate) {
        if (nbStudent < 1 || nbStudent > 20) {
            return false;
        }

        if(trainings.containsKey(code)) {
            return false;
        }

        TrainingPath trainingPath = new TrainingPath(name, code, (byte) nbStudent, startDate, endDate);
        trainings.put(code, trainingPath);  // trainings.putIfAbsent(code, trainingPath);

        return true;
    }

    public Boolean addTraining(String code, String name, int nbStudent, LocalDate endDate) {
        return addTraining(code, name, nbStudent, LocalDate.now(), endDate);
    }

}

