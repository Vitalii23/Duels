package com.info.apache.jdbc.service;

import com.info.apache.model.Account;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private static final String url = "jdbc:mysql://localhost:3306/MySQL";
    private static final String userDB = "root";
    private static final String passwordDB = "root";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    @Override
    public boolean entry(String user, String pass) {
        String query = "SELECT duel.account (login, password) FROM account WHERE (login = ? AND password = ?)";
        boolean entrance = false;
        try {
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.executeQuery();

            entrance = resultSet.next();

        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                se.getMessage();
            }
            try {
                statement.close();
            } catch (SQLException se) {
                se.getMessage();
            }
            try {
                resultSet.close();
            } catch (SQLException se) {
                se.getMessage();
            }
        }
        return entrance;
    }

    @Override
    public void add(String user, String pass) {
        String query = "INSERT INTO duel.account (login, password) VALUES (?, ?)";
        try {
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.executeUpdate(query);
        }  catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        } finally {
            try { connection.close(); } catch (SQLException se) { se.getMessage(); }
            try { preparedStatement.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM duel.account WHERE id=?";
        try{
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        } finally {
            try { connection.close(); } catch (SQLException se) { se.getMessage(); }
            try { preparedStatement.close(); } catch (SQLException se) { se.getMessage(); }
        }
    }

    @Override
    public List<Account> list() {
        return null;
    }
}
