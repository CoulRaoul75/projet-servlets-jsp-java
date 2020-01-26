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
// annotation chemin url 
@WebServlet(name = "AuthentificationValidation", urlPatterns = {"/AuthentificationValidation"})
public class AuthentificationValidation extends HttpServlet {
    
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

        response.setContentType("text/html;charset=UTF-8");

        String lsMessage = "";
        
        HttpSession session = request.getSession();

        /*
        Connexion "interne" locale
         */
        Connection lcnx = null;
        
        // try/catch de la requête de connexion à la bd
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String lsDSN = "jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours";
            lcnx = DriverManager.getConnection(lsDSN, "root", "root");
            lcnx.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        // Méthode controleur >> selectOne
        // Utilisation de la fonction "request.getParameter" pour obtenir les valeurs du formulaire Authentification.jsp
        Utilisateurs u = UtilisateursDAO.selectOne(lcnx, 
                request.getParameter("pseudo"), 
                request.getParameter("mdp"));
        
        
        // vérification de l'authentification avec retour message OK || KO
        if (u == null) {
            lsMessage = "Authentification ratée";
            session.setAttribute("pseudo", "");
        } else {
            lsMessage = "Vous êtes connecté(e)";
            session.setAttribute("pseudo", request.getParameter("pseudo"));
        }

        // envoi du resultat de la connexion dans la page Authentification.jsp
        request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Authentification.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
