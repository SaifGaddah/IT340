/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enseirb.glrt.dao.models;

import java.sql.*;

/**
 *
 * @author USER
 */
public class Connexion {

    public static Connection getconnexion() {
        Connection con = null;

        try {
            Class.forName("org.h2.Driver");// 
            con = DriverManager.getConnection("jdbc:h2:~/test");
            Statement stmt = con.createStatement();
            
            stmt.close();
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
          
        return null;
        }
    }
    
    public void  closeconnexion(Connection con ) {
        try{
        con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
            

}
