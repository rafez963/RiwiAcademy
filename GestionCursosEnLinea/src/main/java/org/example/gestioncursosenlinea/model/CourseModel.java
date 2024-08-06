package org.example.gestioncursosenlinea.model;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import org.example.gestioncursosenlinea.entities.Course;
import org.example.gestioncursosenlinea.persistence.ConnectionDB;
import org.example.gestioncursosenlinea.persistence.IModel.ICourseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModel implements ICourseModel {
    public Course create(Course request) {
        Course couser = null;

        Connection connection = ConnectionDB.openConnection();

        try{
            String SQLquery = "INSERT INTO Courses(name, description) VALUES(? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1){
                return request;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }
        return null;
    }

    public void delete(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        try{
        String SQLquery = "DELETE FROM Course WHERE course_ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            ConnectionDB.closeConnection();
        }

    }

    public List<Course> readAll(int id) {
        Connection connection = ConnectionDB.openConnection();
        List<Course> courses = new ArrayList<Course>();

        try{
            String SQLquery = "SELECT * FROM Courses";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Course course = new Course(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                    courses.add(course);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection();
        }

        return null;
    }

    public Course update(Course request, int id) throws SQLException {
        Connection connection = ConnectionDB.openConnection();

        try {
            String SQLquery = "UPDATE Course SET name = ?, description = ? WHERE course_ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getDescription());
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
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
