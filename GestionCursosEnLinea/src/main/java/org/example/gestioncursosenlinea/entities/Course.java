package org.example.gestioncursosenlinea.entities;

public class Course {
    private int courseID;
    private String name;
    private String description;

    public Course() {
    }

    public Course(int courseID, String name, String description) {
        this.courseID = courseID;
        this.name = name;
        this.description = description;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseID=" + courseID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
