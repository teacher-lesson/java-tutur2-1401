package com.example.dao;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbHelper {

    private static final String driver = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://localhost:3306/chat";
    private static final String username = "root";
    private static final String password = "";


    @SneakyThrows
    public static Connection createNewConnection() {
        return DriverManager.getConnection(
                url, username, password
        );
    }

    @SneakyThrows
    public static Statement createStatement() {
        return createNewConnection().createStatement();
    }

    @SneakyThrows
    public static int runModifiyQuery(String sql) {
        final Statement statement = createStatement();
        final int update = statement.executeUpdate(sql);
        statement.close();
        return update;
    }

    @SneakyThrows
    public static ResultSet runQuery(String sql) {
        final Statement statement = createStatement();
        final ResultSet rs = statement.executeQuery(sql);
        statement.close();
        return rs;
    }
}
