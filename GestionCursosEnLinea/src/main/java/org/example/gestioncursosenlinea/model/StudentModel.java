package org.example.gestioncursosenlinea.model;

import org.example.gestioncursosenlinea.entities.Student;
import org.example.gestioncursosenlinea.persistence.ConnectionDB;
import org.example.gestioncursosenlinea.persistence.IModel.IStudentModel;
import org.example.gestioncursosenlinea.utils.enums.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IStudentModel {
    @Override
    public Student create(Student request) {
        Student student = null;
        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "INSERT INTO Student(name, email, estatus) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getEmail());
            preparedStatement.setString(3, request.getEstatus().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return null;
    }

    @Override
    public List<Student> readAll(int id) {

        List<Student> students = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();

        try{

            String SQLquery = "SELECT * FROM Students";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.getStudentID(resultSet.getInt("student_ID"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setEstatus(status.valueOf(resultSet.getString("status")));
                students.add(student);
            }

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            ConnectionDB.closeConnection();
        }


        return null;
    }

    @Override
    public List<Student> readByEmail(String email) {
        return null;
    }

    @Override
    public Student update(Student request, int id) throws SQLException {
        Connection connection = ConnectionDB.openConnection();
        try {
            String SQLquery = "UPDATE students SET name = ?, email = ?, status = ? WHERE student_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getEmail());
            preparedStatement.setString(3, request.getEstatus());
            preparedStatement.setInt(4, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }
        return null;
    }
    //student_ID INT AUTO_INCREMENT PRIMARY KEY,
    //    name VARCHAR(100) NOT NULL,
    //    email VARCHAR(255) NOT NULL UNIQUE,
    //    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
}
