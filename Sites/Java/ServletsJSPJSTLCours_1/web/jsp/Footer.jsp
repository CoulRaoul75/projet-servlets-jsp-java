<%-- 
    Document   : Footer
    Created on : 23 janv. 2020, 10:26:48
    Author     : vanessa
--%>

<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <!DOCTYPE html>

<%
SimpleDateFormat sdfJour = new SimpleDateFormat("EEEE dd MMMM yyyy");
SimpleDateFormat sdfHeure = new SimpleDateFormat("HH:mm"); String lsJour = sdfJour.format(new Date());
String lsHeure = sdfHeure.format(new Date()); out.print("Nous sommes le " + lsJour + " et il est " + lsHeure); 
%>



