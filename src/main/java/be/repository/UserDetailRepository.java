package be.repository;

import be.config.MySQLConfig;
import be.model.Account;
import be.model.UserDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetailRepository {
    public void addUserDetail(UserDetail userDetail) {
        String query = "INSERT INTO userdetail (firstName, lastName, email, accountUsername)" +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = MySQLConfig.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getEmail());
            statement.setString(4, userDetail.getAccount().getUsername());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static UserDetail getUserDetail(String email) {
        String query = "SELECT * FROM userdetail WHERE email= '" + email + "'";

        try (Connection connection = MySQLConfig.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            if (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String emailId = resultSet.getString("email");
                String accountUsername = resultSet.getString("accountUsername");

                AccountRepository accountRepository = new AccountRepository();
                Account account = accountRepository.getAccount(accountUsername);



                return new UserDetail(firstName, lastName, emailId, account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<UserDetail> getAllUserDetails() {
        String query = "SELECT * FROM userdetail";

        List<UserDetail> userDetails = new ArrayList<>();

        try (Connection connection = MySQLConfig.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String emailId = resultSet.getString("email");
                String accountUsername = resultSet.getString("accountUsername");

                AccountRepository accountRepository = new AccountRepository();
                Account account = accountRepository.getAccount(accountUsername);

                userDetails.add(new UserDetail(firstName, lastName, emailId, account));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    public void updateUserDetail(UserDetail userDetail) {
        String query = "UPDATE userdetail SET firstname = ?, lastname = ?, email = ?, accountUsername = ? WHERE email = ?";

        try (Connection connection = MySQLConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, userDetail.getFirstName());
            statement.setString(2, userDetail.getLastName());
            statement.setString(3, userDetail.getEmail());
            statement.setString(4, userDetail.getAccount().getUsername());
            statement.setString(5, userDetail.getEmail());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteUserDetail(String email) {
        String query = "DELETE FROM userdetail WHERE email = ?";

        try (Connection connection = MySQLConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
