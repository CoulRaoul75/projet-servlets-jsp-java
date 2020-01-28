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
    
    /**
     * 
     * @param cnx
     * @return 
     */
    public static List<Produits> selectAll(Connection cnx) {
        
        // instantiation de l'objet tableau Produits
        List<Produits> list = new ArrayList();
        String lsSQL = "CALL produitsSelectAll";
        
        try {
            // Exécution et traitement de la requête SQL > utilisation de la PS
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            ResultSet lrs = lpst.executeQuery();
                
                // Faire un TANT QUE pour traiter chaque valeur de l'objet produit
                while (lrs.next()){
                    Produits prod = new Produits(
                    lrs.getInt(1),
                    lrs.getString(2),
                    lrs.getDouble(3),
                    lrs.getString(5));
                    list.add(prod);
                }
                lrs.close();
                lpst.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            Produits prod = new Produits(0, e.getMessage(), 0.0);
            list.add(prod);
    }
        
     return list;

    } // selectAll
    
    public static Produits selectOne(Connection cnx, int id){
        Produits prod = null;

        String lsSQL = "SELECT * FROM produits WHERE id_produit=?";

        try {
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            
            lpst.setInt(1, id);
            
            ResultSet lrs = lpst.executeQuery();
            
            if (lrs.next()) {
                prod = new Produits(
                        lrs.getInt(1), 
                        lrs.getString(2), 
                        lrs.getDouble(3), 
                        lrs.getString(5));
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            prod = new Produits(0, e.getMessage(), 0.0);
        }

        return prod;
    }// selectOne
    
    /**
     * 
     * @param cnx
     * @param tCriteres
     * @return 
     */
    public static List<Produits> selectFew(Connection cnx, String[] tCriteres) {
        List<Produits> list = new ArrayList();

        StringBuilder lsbSQL = new StringBuilder();
        
        lsbSQL.append("SELECT * FROM produits WHERE ");
        
        for (int i = 0; i < tCriteres.length; i++) {
            lsbSQL.append("id_produit=? OR ");
        }
        lsbSQL.delete(lsbSQL.length() - 4, lsbSQL.length() - 1);
        lsbSQL.append(" ORDER BY designation ");

        System.out.println(lsbSQL.toString());

        //String lsSQL = "SELECT * FROM produits WHERE id_produit in(" + asCriteres + ") ORDER BY designation ";
        try {

            PreparedStatement lpst = cnx.prepareStatement(lsbSQL.toString());
            for (int i = 0; i < tCriteres.length; i++) {
                String critere = tCriteres[i];
                lpst.setString(i + 1, critere);
            }
            ResultSet lrs = lpst.executeQuery();
            
            while (lrs.next()) {
                Produits prod = new Produits(
                        lrs.getInt(1), 
                        lrs.getString(2), 
                        lrs.getDouble(3), 
                        lrs.getString(5));
                list.add(prod);
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            Produits prod = new Produits(0, e.getMessage(), 0.0);
            list.add(prod);
        }

        return list;
    } /// selectFew
    
    /**
     * 
     * @param cnx
     * @return 
     */
    public static int getCount(Connection cnx) {
        int liCount = 0;
        try {
            PreparedStatement lpst = cnx.prepareStatement("SELECT COUNT(*) FROM produits");

            ResultSet lrs = lpst.executeQuery();
            lrs.next();
            liCount = lrs.getInt(1);
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            liCount = -1;
        }
        return liCount;
    } /// getCount
}
