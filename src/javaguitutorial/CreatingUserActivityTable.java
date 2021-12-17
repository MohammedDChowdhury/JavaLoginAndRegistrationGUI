/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguitutorial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w1726676
 */
public class CreatingUserActivityTable {

    public static void createUserActivityTable() {
        Connection connection = ConnectDB.getConnection();
        String sql = "CREATE TABLE if not exists UserActivityTable (\n" 
                + "userLogId INTEGER         PRIMARY KEY,"
                + "userName VARCHAR (20),"
                + "loginDateTime DATETIME,"
                + "logoutDateTime DATETIME,"
                + "FOREIGN KEY(userLogId) REFERENCES userDetailsTable(userId)"
                + ");";

        try {
            Statement sqlStatement = connection.createStatement();//if this line throws an exception we display an error
            sqlStatement.executeUpdate(sql); //if this line throws an exception we display an error
            System.out.println("User Activity table has been created!");
        } catch (Exception e) {
            System.out.println("Error creating User Activity table" + e.getMessage());
        }

    }
}
