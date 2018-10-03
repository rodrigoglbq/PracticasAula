<%-- 
    Document   : CalcularEdad
    Created on : 01-oct-2018, 17:40:29
    Author     : Rodrigo
--%>

<%@page import="java.time.Period"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
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
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            LocalDate edad = LocalDate.parse(request.getParameter("edad"));
            LocalDate hoy = LocalDate.now();
            
            Period periodo = Period.between(edad, hoy);
           
            
        
        %>
       <% if(periodo.isNegative()){
             out.println("<h1>No has nacido aún.</h1>");
           } %>
        <h1><%=nombre%> tienes, <%=periodo.getYears()%> años, <%=periodo.getMonths()%> meses y <%=periodo.getDays()%> días. </h1>
    </body>
</html>
