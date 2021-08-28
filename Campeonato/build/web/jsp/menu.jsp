<%-- 
    Document   : menu
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@ page import="javax.swing.JOptionPane"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %>
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
          HttpSession s =request.getSession();
          if(s.getAttribute("valido")==null){
               response.sendRedirect("../index.jsp?error=Debe Iniciar Sesion");
          }    
          Boolean valido=(Boolean)s.getAttribute("valido");
         //con la variable "valido" sabemos si existe una sesion activa si no la hay direcciona a index con error.
       if(!valido){
              response.sendRedirect("../index.jsp?error=Usuario o Clave Incorrecta");
          }
        String pagina="verPartidos.jsp";
      
        String accion=request.getParameter("accion");
       if(accion!=null){
          if(accion.equals("registrarpartidos")){
               pagina="registroPartido.jsp";
          }else if(accion.equals("verpartidos")){
                pagina="verPartidos.jsp";
                                   }
          else if(accion.equals("editarpartido")){
                
                pagina="editarPartidos.jsp";}
               
            }
               
          //carga del menu superior a escoger por el usuario e incluimos luego la variable "pagina" que contrenda
          //el formulario a visualizar.
          //
           if(request.getParameter("error")!=null) 
            pagina="error.jsp?error="+request.getParameter("error");
            if(request.getParameter("a")!=null && request.getParameter("msg")!=null)
            pagina="error.jsp?error="+request.getParameter("a")+request.getParameter("msg");
          %>
          
          <div class="banner"></div>
    <div class="menuHorizontal">
    
    <div class="opcion"><a href="?accion=registrarpartidos">Registrar Partidos</a></div>
    <div class='separador'><img src='../imagenes/bg-nav-hover.jpg' width='1' height='31' alt='separador'/></div>
    <div class="opcion"><a href="?accion=verpartidos">Ver Partidos</a></div>
    <div class='separador'><img src='../imagenes/bg-nav-hover.jpg' width='1' height='31' alt='separador'/></div>
    
    <div id="cerrar"><a href="cerrarSesion.jsp"><div class="botonMenu">Cerrar Sesion</div></a></div>
</div>
 
<div class="contenido">
  <jsp:include page="<%=pagina%>"/>
</div>
<div class="pie"></div> 
    </body>
</html>
