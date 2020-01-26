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
    
    public static void main(String[] args) {
        
        // Initialisation IMPLICITE de la variable Connection
        Connection lcnx = null;
        
        try {
            // connexion à la bd avec un try / catch - si erreur = envoi de l'erreur pour correction
            Class.forName("org.gjt.mm.mysql.Driver");
            lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours", "root", "root");
            
            /*
            SELECT ALL 
            Resultat de l'affichage des valeurs => OK
             */
            System.out.println("***** SELECT ALL *****");
            // appel de la methode selectAll
            List<Produits> list = ProduitsDAO.selectAll(lcnx);
            // boucle pour affichage des valeurs de la table Produits avec concaténation
            for (Produits produit : list) {
                System.out.println("id produit : " + produit.getId_produit() +
                        " | Désignation : " + produit.getDesignation() +
                        " | Prix : " + produit.getPrix() + 
                        " | Qté : " + produit.getQte_stockee() + 
                        " | Photo : " + produit.getPhoto());
            }
            
            /*
            Mettre ICI autres méthodes CRUD si besoin
            */
            
            // fermeture de la connexion une fois la requête effectué
            lcnx.close();

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
}
