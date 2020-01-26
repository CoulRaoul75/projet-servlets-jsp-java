<%-- 
    Document   : Catalogue
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
    <table border="0">
        <thead>
            <tr>
                <th>Désignation</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Photo</th>
            </tr>
        <body>
            
            <label>
                ${lsbTableProduits.toString()}
                </label>
            
            </tbody>
            </thead> 
    </table>
    <footer>
        <%@include file="Footer.jsp" %>
    </footer>
</html>
