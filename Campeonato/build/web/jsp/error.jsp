<%-- 
    Document   : error
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/1/index1.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body>
        
        <%
        String msgError=request.getParameter("msgError");
         
        %>
        
        
        <h1> Ha ocurrido un error: <%=msgError%></h1>
        <br>
          <form name="validar" action="jsp/formValidar.jsp">
            
            <p><label>Usuario:</label><input type="text" name="idUsuario" value="" /></p>
            <p><label>Contraseña:</label><input type="password" name="clave" value="" /></p>
            <p><label>Tipo de Usuario:</label><select name="tipoUsuario" size="2">
                    <option value="0">Cliente</option>
                    <option value="1">Administrador</option>
                </select>
            <input type="submit" value="inicio de sesión" name="iniciosesion" />
            
        </form> 
        
    </body>
</html>
