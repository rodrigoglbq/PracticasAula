<%-- 
    Document   : MenuCookie
    Created on : 04-oct-2018, 21:23:25
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="../JSP/ControlCookie.jsp" method="post">
        <fieldset>
            <legend>Datos Personales</legend>

            <label for="nom">Nombre: </label>
            <input type="text" name="Nombre" id="nom" placeholder="Nombre de la Cookie">

            <label for="valor">Valor: </label>
            <input type="text" name="Valor" id="valor">

            <input type="submit" name="Enviar" value="Crear">
            <input type="submit" name="Enviar" value="Modificar">
            <input type="submit" name="Enviar" value="Visualizar">
            <input type="submit" name="Enviar" value="Eliminar">
            
            <%  String mensajes = request.getParameter("mensaje");
                if(mensajes !=null){
                    out.println(mensajes);
                }
                
            %>

        </fieldset>
      </form>
    </body>
</html>
