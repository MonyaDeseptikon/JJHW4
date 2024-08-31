package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

        public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3307";
            String user = "root";
            String password = "password";

            try(Connection connection = DriverManager.getConnection(url, user, password)){

                createDatabase(connection);
                System.out.println("Database created successfully");

                useDatabase(connection);
                System.out.println("Use database successfully");

                createTable(connection);
                System.out.println("Create table successfully");

            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }


        private static void createDatabase(Connection connection) throws SQLException {
            String createDatabaseSQL =  "CREATE DATABASE IF NOT EXISTS SchoolDB;";
            try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
                statement.execute();
            }
        }

        private static void useDatabase(Connection connection) throws SQLException {
            String useDatabaseSQL =  "USE SchoolDB;";
            try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
                statement.execute();
            }
        }

        private static void createTable(Connection connection) throws SQLException {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
            try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
                statement.execute();
            }
        }

}