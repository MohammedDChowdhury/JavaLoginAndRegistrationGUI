/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguitutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author w1726676
 */
public class InsertUserActivity {

    public static void insertActivity(String username2, Date loginDateTime) {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO userActivityTable ('userName', 'loginDateTime') VALUES"
                + "("
                + "'" + username2 + "',"
                + "'" + loginDateTime + "'"
                + ")";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " + username2 + " inserted");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while inserting into User Activity table (date value)");
        }
    }

    public static ResultSet get2(String username2) {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM userActivityTable WHERE username = '" + username2 + "'";
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);

            //  if (result.next()) {
            //    System.out.println("User " + result.getString("userName") + "retrieved!");
            // }
        } catch (Exception e) {
            System.out.println("Error while inserting into User Activity table!" + e.getMessage());
        } finally {

            return result;
        }
    }
    
    
}
