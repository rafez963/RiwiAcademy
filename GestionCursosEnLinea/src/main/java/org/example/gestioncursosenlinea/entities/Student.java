package org.example.gestioncursosenlinea.entities;

import org.example.gestioncursosenlinea.utils.enums.status;

public class Student {
    private int studentID;
    private String name;
    private String email;
    private status estatus;

    public Student() {
    }

    public Student(int studentID, String name, String email, status estatus) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.estatus = estatus;
    }

    public int getStudentID(int studentId) {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(status estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", estatus=" + estatus +
                '}';
    }
}
