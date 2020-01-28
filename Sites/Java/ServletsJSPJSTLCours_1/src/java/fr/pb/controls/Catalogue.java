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
import java.util.ArrayList;
import java.util.List;
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
        
        // parametrage de la page html
        response.setContentType("text/html;charset=UTF-8");
        
        // instanciation du lien et du message
        String lsURL;
        String lsMessage = "";
        
         // récup de la session
        HttpSession session = request.getSession();
        
        // SI la variable de session n'existe pas ou si la variable est vide ... vers Authentification
        // SINON vers catalogue
        if (session.getAttribute("pseudo") == null || session.getAttribute("pseudo").toString().equals("")) {
            lsURL = "Authentification.jsp";
            lsMessage = "Il faut être connecté(e) pour accéder au catalogue";
        } else {
            request.setAttribute("debut", 1);
            request.setAttribute("fin", 30);
            request.setAttribute("pas", 2);

            List<Produits> liste = new ArrayList();
            Produits p1 = new Produits("aaa", 1);
            Produits p2 = new Produits("bbb", 2);
            Produits p3 = new Produits("ccc", 3);
            liste.add(p1);
            liste.add(p2);
            liste.add(p3);
            request.setAttribute("liste", liste);

            //request.setAttribute("tableauDeProduits", tableauDeProduits);
            lsURL = "Catalogue.jsp";
        }
        
        // Le message 
        request.setAttribute("message", lsMessage);
        
        // Redirection vers la page WEB
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/" + lsURL);
        rd.forward(request, response);
        
        //PrintWriter out = response.getWriter();
    } // doGet
    
}
