package org.example.gestioncursosenlinea.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection connection = null;
    public static Connection openConnection(){

        String url = "jdbc:mysql//localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "Rlwl2023.";


        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida. ");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if(connection == null){
                connection.close();
                System.out.println("Conexion cerrada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
