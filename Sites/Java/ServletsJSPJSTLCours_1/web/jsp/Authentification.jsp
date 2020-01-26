<%-- 
    Document   : Authentification
    Created on : 23 janv. 2020, 15:43:08
    Author     : vanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ServletsJSPJSTLCours/css/main.css" /> 
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" /> 

        <title>Authentification</title>
    </head>

    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %> </nav>

        <article>
            <div class="text-center">

                <h1>Se Connecter</h1>
                <br>

                <%--
                <%
                    
                    String lsPseudo = request.getAttribute("pseudo").toString();
                    String lsMDP = request.getAttribute("mdp").toString();
                %> 
                --%>


                <%-- 
                    Formulaire d'authentification
                --%>
                <div class="form-group">
                    <div class="offset-2 col-8 text-center">
                        <form action="/ServletsJSPJSTLCours/AuthentificationValidation" method="POST">

                            <input type="text" name="pseudo" placeholder="Pseudo" class="form-control" value="Casta"/>
                            <br>

                            <input type="password" name="mdp" placeholder="Mot de passe" class="form-control" value="mdp123"/>
                            <br>

                            <button class="btn btn-primary" type="submit" id="btSubmit">Valider</button>

                        </form>
                    </div>
                </div>
                <br>
                <label>
                    ${message}
                </label>
            </div>
        </article>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
