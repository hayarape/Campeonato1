<%-- 
    Document   : registro
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<jsp:useBean id="fachada" scope="application" class="unab.mundo.facade.Campeonato_facade" />
<jsp:useBean id="usuario" class="unba.mundo.dto.Usuario" />
<!DOCTYPE html>
<html>
    <head>
       <link href="../css/styleS.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAMPEONATO</title>
        <link rel="icon" href="../imagenes/icon.gif" type="image/gif" >
    </head>
    <body>
        <%
            String msg="<br>"; 
            
            if(request.getParameter("REGISTRAR")!=null){
                
                if((request.getParameter("nombre")!=null && request.getParameter("correo")!=null) && (request.getParameter("usuario")!=null && request.getParameter("clave")!=null))
                {
                  String nombre=request.getParameter("nombre");
                  String correo=request.getParameter("correo");
                  String usuario1=request.getParameter("usuario");
                  String clave=request.getParameter("clave");
                 if(fachada.registrarUsuario(nombre, correo, usuario1, clave))
                     msg="Usuario Registrado";
                 else
                     msg="Error en el Registro";
                }
                else
                msg="Diligencie todos los campos por favor";
            }
        %>
        
 <div class="banner"></div>
    <div class="menuHorizontal">
         <div class="opcion"><a href="../index.jsp">Inicio</a></div>
    <div class='separador'><img src='../imagenes/bg-nav-hover.jpg' width='1' height='31' alt='separador'/></div>
   
    </div>
 <div class="contenido">
          <div id="contenedor"> 
              
            <div id="inicio2">
                <form name="iniciosesion" action="?">                    
                    <div id="error"><%=msg%></div>
                    <div class="espacio"></div>
                    <label class="texto">Nombre:</label>
                    <p><input class="campo" type="text" name="nombre" value="" required/></p>
                    <label class="texto">Correo:</label>
                    <p><input class="campo" type="text" name="correo" value="" required/></p>
                    <label class="texto">Usuario:</label>
                    <p><input class="campo" type="text" name="usuario" value="" required/></p>
                    <label class="texto">Contrase&ncaron;a:</label>
                    <p><input class="campo" type="password" name="clave" value="" required/></p>  
                    
                    <input id="boton" type="submit" value="REGISTRAR" name="REGISTRAR" />                   
                </form>
            </div>
        </div>
 </div>
<div class="pie"></div> 
    </body>
</html>

