package fr.pb.entities;

import java.io.Serializable;

/**
 *
 * @author vanessa
 */
// Serializable permet de créer un objet (contenant et contenu) sous forme de chaine de caractères
public class Utilisateurs implements Serializable {
    
    // déclaration des attributs
    private String pseudo;
    private String mdp;
    private String email;
    private String qualite;
    
    
    // constructeur vide
    public Utilisateurs () {
    }
    
    // constructeur plein
    public Utilisateurs(String pseudo, String mdp, String email, String qualite){
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.qualite = qualite;
    }

    public Utilisateurs(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }
    
    @Override
    public String toString(){
        return "Utilisateur{" + "Pseudo =" + pseudo + ", MDP =" + mdp + ", Email =" + email + ", Qualité =" + qualite + '}';
    }
    
    
}
