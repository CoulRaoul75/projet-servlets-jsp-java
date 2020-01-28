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

        Connection lcnx = null;
        int affected = 0;

        try {
            // connexion
            Class.forName("org.gjt.mm.mysql.Driver");
            lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/cours", "root", "root");

            // instanciation du DAO
            UtilisateursDAO dao = new UtilisateursDAO(lcnx);

            /*
            SELECT ONE CASTA
             */
            System.out.println("***** SELECT ONE CASTA *****");
            Utilisateurs u = dao.selectOne("Casta", "mdp123");
            System.out.println(u);

            /*
            SELECT ONE pb
             */
            System.out.println("***** SELECT ONE pb *****");
            Utilisateurs u2 = dao.selectOne("p", "b");
            System.out.println(u2);

            /*
            INSERT
             */
            System.out.println("***** Insert *****");
            Utilisateurs newUsr = new Utilisateurs("Blaise", "Al", "blaise@mail.com", "Testeur");
            int liAffected = dao.insert(newUsr);
            System.out.println(liAffected + " inséré(s)");

            /* 
            DELETE
             */
            //System.out.println("***** delete *****");
            //Utilisateurs utASupprimer = new Utilisateurs("lucky", "mdp123", "lucky@gmail.com", "BO");
            //int liAffecte = dao.delete(lcnx, utASupprimer);
            //System.out.println("Supprimé ? " + liAffecte);

            /*
            CLOSE
             */
            lcnx.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
