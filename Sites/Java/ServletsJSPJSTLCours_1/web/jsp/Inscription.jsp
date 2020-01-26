<%-- 
    Document   : FormInscription
    Created on : 24 janv. 2020, 18:02:49
    Author     : vanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ServletsJSPJSTLCours/css/main.css" /> 
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
        <title>Inscription</title>

    </head>
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article>
            <div class="text-center">
                <h1>S'inscrire</h1>
                <br> 
                <div class="form-group">
                    <div class="offset-2 col-8 text-center">
                        
                        <form action="/ServletsJSPJSTLCours/Inscription" method="POST">
                            <input type="text" name="pseudo" placeholder="Pseudo" class="form-control"/> <br>
                            <input type="email" name="email" placeholder="Email" class="form-control"/> <br>
                            <input type="password" name="mdp" placeholder="Mot de Passse" class="form-control" /><br>
                            <input type="text" name="Qualité" placeholder="Qualité" class="form-control" />
                            <button id="btSubmit" type="submit" class="btn btn-danger mt-3">S'inscire</button>
                        </form>
                        <br> 
                        <label>
                            ${message}
                        </label>
                    </div>
                </div>
            </div>
        </article>
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>