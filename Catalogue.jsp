<%-- 
    Document   : Catalogue.jsp
    Created on : 25 janv. 2020, 22:38:23
    Author     : vanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ServletsJSPJSTLCours/css/main.css" /> 
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" /> 

        <title>Catalogue</title>
    </head>
    <header>
        <%@include file="Header.jsp" %>
    </header>
    <nav>
        <%@include file="Nav.jsp" %>
    </nav>
    
    <article id="articleAccueil">
            <h1>CATALOGUE</h1>
            <br>
            <table>
                <thead>
                    <tr>
                        <th>Désignation</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <co:forEach var="produit" items="${liste}" >
                        <tr>
                            <td><co:out value="${produit.designation}" /></td>
                            <td><co:out value="${produit.prix}" /></td>
                        </tr>
                    </co:forEach>
                </tbody>
            </table>
            <label class="messageOrange">
                ${message}
            </label>
            <br><br>

        </article>
    
    
    <footer>
        <%@include file="Footer.jsp" %>
    </footer>
</html>
