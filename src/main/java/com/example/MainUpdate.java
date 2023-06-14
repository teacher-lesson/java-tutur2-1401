package com.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainUpdate {

    @SneakyThrows
    public static void main(String[] args) {

        Class.forName("org.mariadb.jdbc.Driver"); // Regiser Driver Manager

        final Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/university",
                "root",
                ""
        );

        final Statement statement = connection.createStatement();

        final String sql = "UPDATE students SET first_name = 'amir' WHERE first_name = 'hassan';";
        statement.executeUpdate(sql);

        statement.close();
        connection.close();

    }
}
