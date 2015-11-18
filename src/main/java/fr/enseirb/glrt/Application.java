/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enseirb.glrt;

import java.sql.*;

/**
 *
 * @author USER
 */
public class Application {

    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.h2.Driver");// 
            con = DriverManager.getConnection("jdbc:h2:~/test");
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE table(user varchar(20))");
            stmt.execute("INSERT INTO table(user) VALUES ('CHERIFANAJ')");
            stmt.execute("INSERT INTO table(user) VALUES ('GaddahSaifeddine')");
            ResultSet rs = stmt.executeQuery("SElECT * from table");
            while (rs.next()) {
                String name = rs.getString("user");
                System.out.println(name);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
