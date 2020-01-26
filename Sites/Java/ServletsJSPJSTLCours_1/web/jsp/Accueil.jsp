<%-- 
    Document   : Accueil
    Created on : 23 janv. 2020, 10:26:59
    Author     : vanessa
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ServletsJSPJSTLCours/css/main.css" />
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" /> 
        
    
        <title>Accueil.jsp</title>
    </head>
    
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article id="articleAccueil"> 
            <p class="display-4">Accueil<p>
            
            <label class="messageOrange">
                ${message}
            </label>
            <br><br>
            <img src="/ServletsJSPJSTLCours/images/tree.jpg" alt="Photo" title="Photo" width=""/>
        </article>
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>