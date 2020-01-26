<%-- 
    Document   : Nav
    Created on : 23 janv. 2020, 10:26:37
    Author     : vanessa
--%>

<%-- Document : Nav.jsp --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-dark bg-dark">

<ul class="nav justify-content-center">
    <li class="nav-item"> 
        <a class="nav-link" href="/ServletsJSPJSTLCours/ControleurPrincipal">Accueil</a>
    </li>
    <li> 
        |
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/ServletsJSPJSTLCours/Authentification">Se connecter</a>
    </li>
    <li>
        |
    </li >
    <li class="nav-item">
        <a class="nav-link" href="/ServletsJSPJSTLCours/Catalogue">Catalogue</a>
    </li>
    <li>
        |
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/ServletsJSPJSTLCours/PanierCTRL?action=afficherPanier">Panier</a> 
    </li>
    <li>
        |
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/ServletsJSPJSTLCours/Deconnexion">Se déconnecter</a>
    </li>
    <li>
        | </li>
    <li class="nav-item">
        <a class="nav-link" href="/ServletsJSPJSTLCours/Inscription">S'inscrire</a>
    </li> 
</ul>
</nav>
