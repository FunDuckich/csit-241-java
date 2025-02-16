package org.knit.lab1sem2;

public class Complaint {
    private final String description;
    private final ComplexityLevel complexityLevel;

    public Complaint(String description, ComplexityLevel complexityLevel) {
        this.description = description;
        this.complexityLevel = complexityLevel;
    }

    public String getDescription() {
        return description;
    }

    public ComplexityLevel getComplexityLevel() {
        return complexityLevel;
    }

    @Override
    public String toString() {
        return "Жалоба: '" + getDescription() + "', Уровень сложности: " + getComplexityLevel();
    }
}
