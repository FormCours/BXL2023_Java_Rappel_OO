package bxl.formation.demo.models;

import java.time.LocalDate;

public class TrainingPath {

    // Champs -> Attributes
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private byte nbStudent;

    // Constructeur
    public TrainingPath(String name, String code, byte nbStudent) {
        if(nbStudent <= 0) {
            throw new RuntimeException("Le nombre de stagiaire doit être positif");
        }

        this.name = name;
        this.nbStudent = nbStudent;
        this.code = code;
    }

    public TrainingPath(String name, String code, byte nbStudent, LocalDate startDate, LocalDate endDate) {
        // L'appel du "this" (ou "super") doit toujours être la premier ligne executé (╯°□°）╯︵ ┻━┻
        this(name, code, nbStudent);

        if(startDate.isAfter(endDate)) {
            throw  new RuntimeException("Date invalide !");
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public byte getNbStudent() {
        return nbStudent;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        if(startDate != null && this.endDate != null && startDate.isAfter(endDate)) {
            throw new RuntimeException("La date de debut doit etre avant la date de fin");
        }

        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        if(this.startDate != null && endDate != null && endDate.isBefore(startDate)) {
            throw new RuntimeException("La date de fin doit etre après la date de debut");
        }

        this.endDate = endDate;
    }

    public void setNbStudent(byte nbStudent) {
        if(nbStudent <= 0) {
            throw new RuntimeException("Le nombre de stagiaire doit être positif");
        }

        this.nbStudent = nbStudent;
    }
}
