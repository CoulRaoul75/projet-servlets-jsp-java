package fr.pb.daos;

import fr.pb.entities.Utilisateurs;
import java.sql.*;

/**
 *
 * @author vanessa
 */
public class UtilisateursDAO {
    
    // création de la variable d'instance pour connexion bd
    private Connection icn;
    
    public UtilisateursDAO(Connection icn){
        this.icn = icn;
    }

    /**
     * 
     * @param pseudo
     * @param mdp
     * @return 
     */    
    public Utilisateurs selectOne(String pseudo, String mdp) {
        // instanciation utilisateur 
        Utilisateurs u = new Utilisateurs();
       
        try {
            // création de l'objet "Commande SQL"
            PreparedStatement lpst = icn.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ? AND mdp = ?");

            // valorisation des parametres
            lpst.setString(1, pseudo);
            lpst.setString(2, mdp);

            // exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                u = new Utilisateurs();
                u.setPseudo(lrs.getString(1));
                u.setMdp(lrs.getString(2));
                u.setEmail(lrs.getString(3));
                u.setQualite(lrs.getString(4));
            }
            // fermeture des requêtes
            //lrs.close();
            //lpst.close();

        } catch (SQLException e) {
            //u.setPseudo("-1");
            //u.setMdp(e.getMessage());
        }
        return u;
    } // selectOne

    /**
     * 
     * @param utilisateur
     * @return 
     */
    public int insert(Utilisateurs utilisateur) {
        // création variable de résultat de l'execution de la requete Insert
        int liAffected = 0;
        
        try {
            // --- INSERT SQL
            String lsSQL = "CALL utilisateursInsert(?, ?, ?, ?)";
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = icn.prepareStatement(lsSQL);
            // --- Valorisation du ou des parametre(s)
            lpst.setString(1, utilisateur.getPseudo());
            lpst.setString(2, utilisateur.getMdp());
            lpst.setString(3, utilisateur.getEmail());
            lpst.setString(4, utilisateur.getQualite());
            
            // execution de la requete
            liAffected = lpst.executeUpdate();
            // fermeture de la requete
            lpst.close();
            
        } catch (SQLException e) {
            liAffected = -1;
        }
        return liAffected;
    } /// insert

    public int delete(Utilisateurs utilisateur) {
        // création variable de résultat de l'execution de la requete Delete
        int liAffecte = 0;

        try {
            // DELETE SQL
            String lsSQL = "DELETE FROM utilisateurs WHERE email=? AND mdp=?";
            // Creation de l'objet "commande SQL"
            PreparedStatement lpst = icn.prepareStatement(lsSQL);
            // --- Valorisation du ou des parametre(s)
            lpst.setString(1, utilisateur.getEmail());
            lpst.setString(2, utilisateur.getMdp());
            // execution de la requete
            liAffecte = lpst.executeUpdate();
            // fermeture de la requete
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            liAffecte = -1;
        }
        return liAffecte;
    } /// delete
    
}
