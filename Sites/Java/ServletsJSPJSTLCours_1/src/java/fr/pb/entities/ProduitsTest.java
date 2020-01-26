/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.entities;

/**
 *
 * @author vanessa
 */
public class ProduitsTest {
    
    public static void main(String[] args){
    
    Produits eau = new Produits();
        
        eau.setId_produit(1);
        eau.setDesignation("Evian");
        eau.setPrix(2.5);
        eau.setQte_stockee(40);
        eau.setPhoto("evian.png");
        
        System.out.println(eau.getId_produit());
        System.out.println(eau.getDesignation());
        System.out.println(eau.getPrix());
        System.out.println(eau.getQte_stockee());
        System.out.println(eau.getPhoto());
        
        System.out.println("*****************");
    }
}
    

