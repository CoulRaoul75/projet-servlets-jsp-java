/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.controls;

import fr.pb.daos.ProduitsDAO;
import fr.pb.entities.Produits;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanessa
 */
 // Annotation du chemin 
    @WebServlet(name = "Catalogue", urlPatterns = {"/Catalogue"})   
public class Catalogue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // parametrage de la page html
        response.setContentType("text/html;charset=UTF-8");
        
        /*
        Requête vers BD SQL
        */
        
        // instanciation IMPLICITE de la connexion à la BD
        Connection lcnx = null;
        // Connexion à la bd avec un try/catch
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String lsDSN = "jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/coulraoul_cours";
            lcnx = DriverManager.getConnection(lsDSN, "root", "root");
            lcnx.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        /*
        Affichage de la table Produits avec mise en forme html pour JSP
        */
        
        // instantiation de la table Produits
        Produits prod;
        List produits;
        
        // Utilisation de la class String Builder pour générer un seul type de caractère
        // instanciation de la table Produits en une String Builder
        StringBuilder lsbTableProduits = new StringBuilder();
        
        lsbTableProduits.append("<table border='1'>");
        lsbTableProduits.append("<tbody>");
        
        // méthode du controleur Produits DAO => test OK
        produits = ProduitsDAO.selectAll(lcnx);
        // fonction for pour obtenir toutes les valeurs de la table sous format html table
        for (Object object : produits) {
            prod = (Produits) object;
            lsbTableProduits.append("<tr>");
            lsbTableProduits.append("<td>");
            lsbTableProduits.append(prod.getDesignation());
            lsbTableProduits.append("</td>");
            lsbTableProduits.append("<td>");
            lsbTableProduits.append(prod.getPrix());
            lsbTableProduits.append("</td>");
            lsbTableProduits.append("<td>");
            lsbTableProduits.append(prod.getQte_stockee());
            lsbTableProduits.append("</td>");
            lsbTableProduits.append("<td>");
            lsbTableProduits.append(prod.getPhoto());
            lsbTableProduits.append("</td>");
            lsbTableProduits.append("<td>");
        }
        lsbTableProduits.append("</tbody>");
        lsbTableProduits.append("</table>");
        
        
        // envoi de TableProduits dans la page Catalogue.jsp
        request.setAttribute("Catalogue", lsbTableProduits.toString());
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Catalogue.jsp");
        rd.forward(request, response);
}
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        response.setContentType("text/html;charset=UTF-8");
        
        
        String lsURL = "Catalogue.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);
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
        processRequest(request, response);
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
