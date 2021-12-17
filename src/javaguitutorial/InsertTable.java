/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguitutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author w1726676
 */
public class InsertTable { //for registering

    public static void insert(String username, String firstname, String lastname, String email, String password) {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO userDetailsTable ('userName', 'userFirstName','userLastName','userEmail','userPassword') VALUES"
                + "("
                + "'" + username + "',"
                + "'" + firstname + "',"
                + "'" + lastname + "',"
                + "'" + email + "',"
                + "'" + password + "'"
                + ");";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " + username + " inserted");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while inserting into User table");
        }
    }

    public static ResultSet get(String username, String password) {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM userDetailsTable WHERE username = '" + username + "'" + "AND userPassword = '" + password + "'";
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
            // loop through the result set

            //  if (result.next()) {
            //    System.out.println("User " + result.getString("userName") + "retrieved!");
            // }
        } catch (Exception e) {
            System.out.println("Error while inserting into User table!" + e.getMessage());
        } finally {

            return result;
        }

    }

    public static ResultSet getUsername(String username) {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM userDetailsTable WHERE username = '" + username + "'";
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
            // loop through the result set

            //  if (result.next()) {
            //    System.out.println("User " + result.getString("userName") + "retrieved!");
            // }
        } catch (Exception e) {
            System.out.println("Error while inserting into User table!" + e.getMessage());
        } finally {

            return result;
        }

    }
}
