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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanessa
 */
// annotation chemin
@WebServlet(name = "CatalogueTest", urlPatterns = {"/CatalogueTest"})
public class CatalogueTest extends HttpServlet {


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
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcnx = DriverManager.getConnection("jdbc:mysql://mysql-coulraoul.alwaysdata.net:3306/cours", "root", "root");

            List<Produits> listeProduits = ProduitsDAO.selectAll(lcnx);

            out.println("<h1>Les produits</h1>");
            for (int i = 0; i < listeProduits.size(); i++) {
                Produits produits = listeProduits.get(i);

                out.print("[" + produits.getId_produit()+ "] ");
                out.print(produits.getDesignation() + " : ");
                out.print(produits.getPrix() + " -> ");
                out.println(produits.getPhoto() + "<br>");
            }

            lcnx.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        }
    }
}
