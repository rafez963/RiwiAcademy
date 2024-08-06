package org.example.gestioncursosenlinea.model;

import org.example.gestioncursosenlinea.entities.Enrollment;
import org.example.gestioncursosenlinea.persistence.ConnectionDB;
import org.example.gestioncursosenlinea.persistence.IModel.IEnrollmentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// enrollment_ID INT AUTO_INCREMENT PRIMARY KEY,
//    student_ID INT,
//    course_ID INT,
//    enrollment_date DATE,

public class EnrollmentModel implements IEnrollmentModel {
    public Enrollment create(Enrollment request) {

        Enrollment enrollment = null;
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "INSERT INTO Enrollments(student_ID INT, course_ID INT, enrollment_date) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery, PreparedStatement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, request.getStudentID());
            preparedStatement.setInt(2, request.getCourseID());
            preparedStatement.setDate(3, request.getEnrollmentDate());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return request;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }


        return null;
    }

    public void delete(Integer id) {
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "DELETE FROM Enrollments WHERE enrollment_ID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    public List<Integer> readAll(int id) {
        List<Enrollment> enrollments = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "SELECT * FROM Enrollments";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Enrollment enrollment = new Enrollment();
                enrollment.setEnrollmentID(resultSet.getInt("enrollment_ID"));
                enrollment.setStudentID(resultSet.getInt("student_ID"));
                enrollment.setCourseID(resultSet.getInt("course_ID"));

                enrollments.add(enrollment);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return null;
    }

    public Enrollment update(Enrollment request, int id) throws SQLException {
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "UPDATE Enrollments SET student_ID = ?, course_ID = ?, enrollment_date= ? WHERE enrrollment_ID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1, request.getStudentID());
            preparedStatement.setInt(2, request.getCourseID());
            preparedStatement.setDate(3, request.getEnrollmentDate());
            preparedStatement.setInt(4, id);

            int rowsAffectesd = preparedStatement.executeUpdate();
            if(rowsAffectesd == 1){
                return request;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return null;
    }
}
