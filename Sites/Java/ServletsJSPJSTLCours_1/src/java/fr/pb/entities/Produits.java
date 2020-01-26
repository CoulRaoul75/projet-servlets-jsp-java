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
public class Produits {
    // déclaration des attributs
    private int id_produit;
    private String designation;
    private double prix;
    private int qte_stockee;
    private String photo; 

    // constructeur vide
    public Produits() {
    }
    
    // constructeur plein

    public Produits(int id_produit, String designation, double prix, int qte_stockee, String photo) {
        this.id_produit = id_produit;
        this.designation = designation;
        this.prix = prix;
        this.qte_stockee = qte_stockee;
        this.photo = photo;
    }
    
    public Produits(String designation, double prix, int qte_stockee, String photo) {
        this.designation = designation;
        this.prix = prix;
        this.qte_stockee = qte_stockee;
        this.photo = photo;
    }
    
    
    // getter et setter de chq attribut

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQte_stockee() {
        return qte_stockee;
    }

    public void setQte_stockee(int qte_stockee) {
        this.qte_stockee = qte_stockee;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    @Override
    public String toString(){
        return "Produit{" + "id_produit=" + id_produit + ", Désignation=" + designation + ", Prix=" + prix + ", Qté stockée =" + qte_stockee + ", Photo=" + photo + '}';
        }
    
}
