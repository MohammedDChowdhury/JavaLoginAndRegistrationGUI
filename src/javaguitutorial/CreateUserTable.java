/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguitutorial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author w1726676
 */
public class CreateUserTable {

    public static void main(String[] args) {
        Connection con = ConnectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists userDetailsTable (\n"
                + "            userId INTEGER       PRIMARY KEY AUTOINCREMENT,\n"
                + "            userName VARCHAR (20),\n"
                + "            userFirstName VARCHAR (20),\n"
                + "            userLastName VARCHAR (20),\n"
                + "            userEmail VARCHAR (25),\n"
                + "            userPassword VARCHAR (25)\n" 
                + ");";

        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
          
            }
        }
    }
}
