package org.example.gestioncursosenlinea.entities;

public class Grade {
    private int gradeID;
    private int enrollmentID;
    private double grade;
    private String descripcion;

    public Grade() {
    }

    public Grade(int gradeID, int enrollmentID, double grade, String descripcion) {
        this.gradeID = gradeID;
        this.enrollmentID = enrollmentID;
        this.grade = grade;
        this.descripcion = descripcion;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "gradeID=" + gradeID +
                ", enrollmentID=" + enrollmentID +
                ", grade=" + grade +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
