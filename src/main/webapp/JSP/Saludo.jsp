<%-- 
    Document   : Saludo
    Created on : 01-oct-2018, 16:56:48
    Author     : Rodrigo
--%>

<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "‐//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%
          
         String nombre = request.getParameter("Nombre");
          String sex = null;
          sex = request.getParameter("Sexo").equals("Hombre") ? "señor " : "señora ";
          
          int hora = LocalTime.now().getHour();
          
          String saludo = null;
          if(hora>=8 && hora<13){
              saludo = "nos dias ";
          }if(hora>=13 && hora<21){
           saludo = "nas tardes ";
          }else{
              saludo = "nas noches ";
          }
        %>
        <h1>Bue<%=saludo%> <%=sex%> <%=nombre%>.</h1>
        <a href= index.html>Menú principal.</a>
    </body>
</html>
