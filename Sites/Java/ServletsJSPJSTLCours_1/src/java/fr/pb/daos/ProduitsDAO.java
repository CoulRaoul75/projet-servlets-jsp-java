/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.daos;

import fr.pb.entities.Produits;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanessa
 */
public class ProduitsDAO {
    
    public static List<Produits> selectAll(Connection cnx) {
        
        // instantiation de l'objet tableau Produits
        List<Produits> list = new ArrayList();
        // instantiation de l'objet 1 produit
        Produits prod;
        
        try {
            // Exécution et traitement de la requête SQL > utilisation de la PS
            Statement lst = cnx.createStatement(); 
            ResultSet lrs = lst.executeQuery("CALL produitsSelectAll");
                
                // Faire un TANT QUE pour traiter chaque valeur de l'objet produit
                while (lrs.next()){
                    prod = new Produits();
                    prod.setId_produit(lrs.getInt(1));
                    prod.setDesignation(lrs.getString(2));
                    prod.setPrix(lrs.getDouble(3));
                    prod.setQte_stockee(lrs.getInt(4));
                    prod.setPhoto(lrs.getString((5)));
                    list.add(prod);
                }
               
    } catch (SQLException e){
    }
        
     return list;

    } // select All
    
}
