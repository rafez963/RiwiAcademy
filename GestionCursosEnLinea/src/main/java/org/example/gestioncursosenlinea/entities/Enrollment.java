package org.example.gestioncursosenlinea.entities;

import java.util.Date;

public class Enrollment {
    private int enrollmentID;
    private int studentID;
    private int courseID;

    private Date enrollmentDate;

    public Enrollment() {
    }

    public Enrollment(int enrollmentID, int studentID, int courseID, Date enrollmentDate) {
        this.enrollmentID = enrollmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public java.sql.Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollments{" +
                "enrollmentID=" + enrollmentID +
                ", studentID=" + studentID +
                ", courseID=" + courseID +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
