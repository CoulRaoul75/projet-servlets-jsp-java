/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.controls;

import fr.pb.daos.UtilisateursDAO;
import fr.pb.entities.Utilisateurs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vanessa
 */
@WebServlet(name = "InscriptionValidation", urlPatterns = {"/InscriptionValidation"})
public class InscriptionValidation extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // reponse du serveur de type html
        response.setContentType("text/html;charset=UTF-8");
        // instanciation de la variable message de retour
        String message = "";

        // connexion bd
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours", "coulraoul", "LilouChat08+");
            
            // Instanciation du DAO
            UtilisateursDAO dao = new UtilisateursDAO(lcnx);

            // AJOUT
            // Récupération des saisies du formulaire
            String pseudo = request.getParameter("pseudo");
            String mdp = request.getParameter("mdp");
            String email = request.getParameter("email");
            String qualite = request.getParameter("qualite");
            // Instanciation nouveau utilisateur
            Utilisateurs newUsr = new Utilisateurs(pseudo, mdp, email, qualite);
            // INSERT du DAO
            int liAffected = dao.insert(newUsr);

            // vérif création nouveau utilisateur + message à afficher
            if (liAffected == 1) {
                message = "Vous êtes enregistré(e)";
            } else {
                message = "Enregistrement raté";
            }
            
            System.out.println("Ajouté ? " + liAffected);
            lcnx.close();

        } catch (ClassNotFoundException | SQLException e) {
            message = "Inscription ratée";
        }
        request.setAttribute("message", message);

        // redirection
        String lsURL = "Inscription.jsp";
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/" + lsURL);
        rd.forward(request, response);

    }


}
