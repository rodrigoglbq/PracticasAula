<%-- 
    Document   : ControlCookie
    Created on : 04-oct-2018, 21:22:14
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
    String mensaje = null;
    
    String nombre = request.getParameter("Nombre");
    Cookie cookie = new Cookie(nombre,request.getParameter("Valor"));
    Cookie[] cookies = request.getCookies();
    
    if (cookie != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(nombre)) {
                cookie = cookies[i];
                break;
            }
        }
    }
    
    if (request.getParameter("Enviar").equals("Crear")) {
        if (cookie == null) {
            cookie = new Cookie(nombre, request.getParameter("Valor"));
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            mensaje = "Se ha creado correctamente la cookie "+ nombre + "=" + cookie.getValue();
            
        } else {
            mensaje = "La cookie"+nombre+"="+cookie.getValue()+"ya existe.";
        }
    } else if (request.getParameter("Enviar").equals("Visualizar")) {
        if (cookie != null) {
           mensaje = "La cookie es: " +nombre+"="+cookie.getValue(); 
        } else {
             mensaje = "La cookie no existe.";
           
        }
    } else if (request.getParameter("Enviar").equals("Eliminar")) {
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            mensaje = "Se ha eliminado la cookie: " + nombre + "=" + cookie.getValue();
        } else {
            mensaje = "No se ha podido eliminar la cookie porque no existe.";
        }
        
    } else if (request.getParameter("Enviar").equals("Modificar")) {
        if (cookie != null) {
                cookie.setValue(request.getParameter("Valor"));
		response.addCookie(cookie);
                mensaje="Ahora el nombre de la cookie es: "+nombre+":"+cookie.getValue();
        }
        mensaje = "No existe esa Cookie por tanto no se puede modificar";
    }
    response.sendRedirect("MenuCookie.jsp?mensaje=" + mensaje);

 
%>
