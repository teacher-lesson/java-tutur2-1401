package com.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        Class.forName("org.mariadb.jdbc.Driver"); // Regiser Driver Manager

        final Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/university",
                "root",
                ""
        );

        final Statement statement = connection.createStatement();

        final ResultSet rs = statement.executeQuery("SELECT * FROM `students`");
//        statement.executeUpdate()

        while (rs.next()) {
            System.out.print(rs.getString("first_name"));
            System.out.println(" " + rs.getString("last_name"));
        }

        rs.close();
        statement.close();
        connection.close();

    }
}
