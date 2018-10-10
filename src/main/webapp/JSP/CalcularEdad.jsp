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
            String frase = null;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate edad = LocalDate.parse(request.getParameter("edad"));
            LocalDate hoy = LocalDate.now();

            Period periodo = Period.between(edad, hoy);
            
            String anio;
            String mes;
            String dia;
        %>
            

        <%
            if (periodo.isNegative()) {
                out.println("<h1>No has nacido aún.</h1>");
            }
            if (periodo.getYears()<=0) {
                anio = "";
            }else if(periodo.getYears()== 1) {
                anio = "año,";
            } else {
                anio = "años,";
            }
            
            if(periodo.getMonths()<=0){
                mes="";
                
            }else if(periodo.getMonths()==1){
                mes="mes,";
            }else{
               mes = "meses,"; 
            }

            if(periodo.getDays()<=0){
                dia="";
            }else if(periodo.getDays()==1){
                dia="y día";
            }else{
                dia = "y días";
            }
            
        %>
        <% %>
        <h1><%=nombre%> tienes, <%= periodo.getYears()+anio%><%=periodo.getMonths()+mes%><%=periodo.getDays()+dia%> </h1>
    </body>
</html>
