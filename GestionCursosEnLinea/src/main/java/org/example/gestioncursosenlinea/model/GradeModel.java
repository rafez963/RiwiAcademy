package org.example.gestioncursosenlinea.model;

import org.example.gestioncursosenlinea.entities.Grade;
import org.example.gestioncursosenlinea.persistence.ConnectionDB;
import org.example.gestioncursosenlinea.persistence.IModel.IGradeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// //##Grades Table
//        //CREATE TABLE Grades (
//        //    grade_ID INT AUTO_INCREMENT PRIMARY KEY,
//        //    enrollment_ID INT,
//        //    grade DECIMAL(5, 2) CHECK (grade BETWEEN 0 AND 100),
//        //    description TEXT,
//        //    FOREIGN KEY (enrollment_ID) REFERENCES Enrollments(enrollment_ID) ON DELETE CASCADE
//        //);
public class GradeModel implements IGradeModel {
    @Override
    public Grade create(Grade request) {

        Grade grade = new Grade();
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "INSERT INTO Grades(enrollment_ID, grade, description) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, request.getEnrollmentID());
            preparedStatement.setDouble(2,request.getGrade());
            preparedStatement.setString(3, request.getDescripcion());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return  request;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection =  ConnectionDB.openConnection();

        try{
            String SQLquery = "DELETE FROM Grade WHERE grade_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public Grade update(Grade request, int id) throws SQLException {
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "UPDATE Grade SET enrollment_ID = ?, grade = ?, description = ? WHERE grade_ID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1,request.getEnrollmentID());
            preparedStatement.setDouble(2, request.getGrade());
            preparedStatement.setString(3, request.getDescripcion());
            preparedStatement.setInt(4, id);

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
}
