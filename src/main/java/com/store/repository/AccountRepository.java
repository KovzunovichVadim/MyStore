package com.store.repository;

import com.store.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private final String URL = "jdbc:postgresql://localhost:5432/store";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "root";

    private static final String INSERT_USERS_SQL = "INSERT INTO accounts (first_name,last_name,email) VALUES (?,?,?);";
    private static final String SELECT_ACCOUNT_BY_ID = "SELECT id,first_name,last_name,email,created FROM accounts WHERE id =?;";
    private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM accounts";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id=?;";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET first_name=?,last_name=?,email=? WHERE id=?;";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public void createAccount(Account account) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, account.getFirstname());
            preparedStatement.setString(2, account.getLastname());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account readAccount(Long id) {
        Account account = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String created = resultSet.getString("created");
                account = new Account(id, firstname, lastname, email, created);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return account;
    }

    public boolean updateAccount(Account account) {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setString(1, account.getFirstname());
            preparedStatement.setString(2, account.getLastname());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setLong(4, account.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
            return rowUpdate;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setLong(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            return rowDeleted;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Account> readAllAccount(){
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String created = resultSet.getString("created");
                accounts.add(new Account(id,firstname,lastname,email,created));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accounts;
    }
}
