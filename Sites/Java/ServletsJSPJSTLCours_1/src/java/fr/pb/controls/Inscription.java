/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.controls;

import fr.pb.daos.UtilisateursDAO;
import fr.pb.entities.Utilisateurs;
import java.io.IOException;
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
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // reponse vers page html
        response.setContentType("text/html;charset=UTF-8");
        // chemin url vers fichier js
        String lsURL = "Inscription.jsp";
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/" + lsURL);
        rd.forward(request, response); 
    }
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
        
        // instanciation de la variable de retour
        String lsMessage = "";
        
        // création d'une variable de session de connexion 
        HttpSession session = request.getSession();
        
        // connextion interne locale
        Connection lcnx = null;
        
        // connexion bd
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            java.lang.String lsDSN = "jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours";
            lcnx = DriverManager.getConnection(lsDSN, "root", "root");
            lcnx.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        // méthode INSERT pour nouvel utilisateur > UtilisateursDAOTest = OK
        int affected;
        // instanciation nouvel utilisateur
        Utilisateurs usr = new Utilisateurs(request.getParameter("pseudo"), request.getParameter("mdp"), request.getParameter("email"), request.getParameter("email"));
        // methode de création du nouvel utilisateur
        affected = UtilisateursDAO.insert(lcnx, usr);

        if (affected == 1) {
            lsMessage = "Vous êtes enregistré(e)";
            session.setAttribute("pseudo", request.getParameter("pseudo"));
        } else {
            lsMessage = "Enregistrement raté";
            session.setAttribute("pseudo", "");
        }

        request.setAttribute("message", lsMessage);
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/AuthentificationValidation.jsp");
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
