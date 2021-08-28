<%-- 
    Document   : index
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/styleS.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="icon" href="imagenes/icon.gif" type="image/gif" >
        <title>CAMPEONATO</title>
    </head>
    <body>
        <%
            String msg="<br>"; 
            if(request.getParameter("error")!=null){
                msg="<div class='espacio'></div>"+request.getParameter("error");
            }                
        %>
        
 <div class="banner"></div>
    <div class="menuHorizontal">
    </div>
 <div class="contenido">
          <div id="contenedor"> 
              
            <div id="inicio">
                <form name="iniciosesion" action="jsp/formValidar.jsp">                    
                    <div id="error"><%=msg%></div>
                    <div class="espacio"></div>
                    <label class="texto">Usuario:</label>
                    <p><input class="campo" type="text" name="idUsuario" value="" required /></p>
                    <label class="texto">Contrase&ncaron;a:</label>
                    <p><input class="campo" type="password" name="clave" value="" required/></p>        
                    <!--<label class="texto">Tipo de Usuario:</label>
                    <p><select name="tipoUsuario" size="1">
                        <option value="0">Usuario</option>
                        <option value="1">Administrador</option>
                    </select></p> -->
                            <input id="boton" type="submit" value="Iniciar Sesion" name="iniciarsesion" />                       
                            <a class="registro" href="jsp/registroUsuario.jsp">Registrarme</a>
                            
                </form>
            </div>
        </div>
 </div>
<div class="pie"></div> 
    </body>
</html>

