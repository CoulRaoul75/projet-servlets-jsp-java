package fr.pb.daos;

import fr.pb.entities.Utilisateurs;
import java.sql.*;

/**
 *
 * @author vanessa
 */
public class UtilisateursDAO {

    /**
     * 
     * @param cnx
     * @param pseudo
     * @param mdp
     * @return 
     */
    public static Utilisateurs selectOne(Connection cnx, String pseudo, String mdp) {

        Utilisateurs u = new Utilisateurs();
        
        
        try {
            // création de l'objet "Commande SQL"
            PreparedStatement lpst = cnx.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ? AND mdp = ?");

            // valorisation des parametres
            lpst.setString(1, pseudo);
            lpst.setString(2, mdp);

            // exécution de la requête
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                u.setPseudo(lrs.getString(1));
                u.setMdp(lrs.getString(2));
                u.setEmail(lrs.getString(3));
                u.setQualite(lrs.getString(4));
            }
            // fermeture des requêtes
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            //u.setPseudo("-1");
            //u.setMdp(e.getMessage());
        }
        return u;
    } // selectOne

    /**
     * 
     * @param cnx
     * @param u
     * @return 
     */
    public static int insert(Connection cnx, Utilisateurs u) {
        int liAffected = 0;
        
        try {
            // --- INSERT
            String lsSQL = "CALL utilisateursInsert(?, ?, ?, ?)";
            // --- Creation de l'objet "commande SQL"
            PreparedStatement lpst = cnx.prepareStatement(lsSQL);
            // --- Valorisation du ou des parametre(s)
            lpst.setString(1, u.getPseudo());
            lpst.setString(2, u.getMdp());
            lpst.setString(3, u.getEmail());
            lpst.setString(4, u.getQualite());
            
            // --- Execution de la requete
            liAffected = lpst.executeUpdate();
        } catch (SQLException e) {
            liAffected = -1;
        }
        return liAffected;
    } /// insert

}
