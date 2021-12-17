/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaguitutorial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author w1726676
 */
public class JavaGUIMainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreatingUserActivityTable.createUserActivityTable();
                //  InsertTable.insert("sda", "John", "Doe", "emailtest2@email.com", "passwordtest");
        // InsertTable.insert("sdsd", "df", "Doe", "emailtest2@email.com", "passwordtest");
        FirstGUI firstGUI = new FirstGUI();
        firstGUI.setVisible(true);
        DB getCon = new DB();
        
       
    }

}
