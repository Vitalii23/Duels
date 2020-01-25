package com.info.apache.jdbc.dao;

import com.info.apache.model.Player;

import java.sql.*;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {

    private static final String url = "jdbc:mysql://localhost:3306/MySQL";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    @Override
    public List<Player> list() {
        String sql = "SELECT * FROM duel";
        List<Player> persons = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Player person = new Player();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setDamage(resultSet.getInt("damage"));
                person.setHealth(resultSet.getInt("health"));

                assert false;
                persons.add(person);
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        } finally {
            try { connection.close(); } catch (SQLException se) { se.getMessage(); }
            try { statement.close(); } catch (SQLException se) { se.getMessage(); }
            try { resultSet.close(); } catch (SQLException se) { se.getMessage(); }
        }
        return persons;
    }
}
