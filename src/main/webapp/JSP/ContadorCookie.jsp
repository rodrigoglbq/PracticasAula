<%-- 
    Document   : ContadorCookie
    Created on : 10-oct-2018, 11:18:22
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
Cookie miCookie = new Cookie("nombre","valor");


Cookie [] cookies = request.getCookies();


for(int i=0; i<cookies.length; i++)
{
    Cookie cookie = cookies[i];


    String identificador = cookie.getName();
    String valor = cookie.getValue();
}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
