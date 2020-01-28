/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.daos;

import fr.pb.entities.Produits;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vanessa
 */
public class ProduitsDAOTest {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        try {
            // connexion à la bd avec un try / catch - si erreur = envoi de l'erreur pour correction
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours", "coulraoul", "LilouChat08+");
            
            int liCount = ProduitsDAO.getCount(lcnx);
            System.out.println("Nb de produits (Count) : " + liCount);
            
            System.out.println("SelectOne");
            Produits prod = ProduitsDAO.selectOne(lcnx, 11);
            System.out.println(prod);
            
            List<Produits> list = ProduitsDAO.selectAll(lcnx);
            // String lsCriteres = "1,37";
            String[] tCriteres = {"1", "37"};
            // List<Produits> listeProduits = ProduitsDAO.selectFew(lcnx, lsCriteres);
            // List<Produits> listeProduits = ProduitsDAO.selectFew(lcnx, tCriteres);
            // Connexion.seDeconnecter();
            
            System.out.println("SelectAll");
            for (int i = 0; i < list.size(); i++) {
                Produits produits = list.get(i);

                System.out.print("[" + produits.getId_produit() + "] ");
                System.out.print(produits.getDesignation() + " : ");
                System.out.print(produits.getPrix() + " -> ");
                System.out.println(produits.getPhoto());
            }
             /*
            Apres deconnexion
            */
            // listeProduits = ProduitsDAO.selectFew(lcnx, tCriteres);
            // for (int i = 0; i < listeProduits.size(); i++) {
            //
            // Produits produits = listeProduits.get(i);
            //
            // System.out.print("[" + produits.getIdProduit() + "] ");
            // System.out.print(produits.getDesignation() + " : ");
            // System.out.print(produits.getPrix() + " -> ");
            // System.out.println(produits.getPhoto());
            // }

            
            
            // fermeture de la connexion une fois la requête effectué
            lcnx.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
