/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.daos;

import fr.pb.entities.Utilisateurs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vanessa
 */
public class UtilisateursDAOTest {
    
    public static void main(String[] args) {
        
        Utilisateurs usr = new Utilisateurs("Emile", "tr", "emile@mail.com", "Testeur");
        Connection lcnx = null;
        int affected = 0;
       
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours", "root", "root");

            /*
            SELECT ONE CASTA
             */
            System.out.println("***** SELECT ONE CASTA *****");
            Utilisateurs u = UtilisateursDAO.selectOne(lcnx, "Casta", "mdp123");
            System.out.println(u);
            
            
            /*
            SELECT ONE pb
             */
            System.out.println("***** SELECT ONE pb *****");
            Utilisateurs u2 = UtilisateursDAO.selectOne(lcnx, "p", "b");
            System.out.println(u2);
            
            
            /*
            INSERT
             */
            System.out.println("***** Insert *****");
            affected = UtilisateursDAO.insert(lcnx, usr);
            System.out.println(affected + " inséré(s)");
            
            /*
            CLOSE
             */
            lcnx.close();

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
}
