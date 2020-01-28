/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.controls;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanessa
 */
@WebServlet(name = "ControleurPrincipal", urlPatterns = {"/ControleurPrincipal"})

public class ControleurPrincipal extends HttpServlet {

    // récupération de la page "template" en JSP
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String lsURL = "Accueil.jsp";
        
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);
    } /// doGet 
}
