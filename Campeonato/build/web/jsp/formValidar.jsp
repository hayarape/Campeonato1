<%-- 
    Document   : validar
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<jsp:useBean id="fachada" scope="application" class="unab.mundo.facade.Campeonato_facade" />
<jsp:useBean id="usuario" class="unba.mundo.dto.Usuario" />
         
        
<%      //recibe parametros usuario y clave
        String usuar=request.getParameter("idUsuario");
        String clave=request.getParameter("clave");
      
       //verifica si los campos estan vacios y redirecciona a index con error en caso de estarlo
        if(usuar.isEmpty()){
            response.sendRedirect("../index.jsp?accion=Ingrese su Nombre de Usuario");
        }else if(clave.isEmpty()){
            response.sendRedirect("../index.jsp?error=Ingrese su Clave");
        }else{
             HttpSession s=request.getSession();
            //guardamos el tipo de usuario en sesion s
            s.setAttribute("usuario",usuar);  
            s.setAttribute("clave",clave);
            boolean flag=fachada.iniciarSesion(usuar,clave);
            s.setAttribute("valido", flag);
            
            //validamos con flag si el usuario existe, si existe lo direcciona a menu.jsp, en caso contrario lo direccion con error a index.jsp
            if(flag){
                    response.sendRedirect("menu.jsp"); 
            }else{
                response.sendRedirect("../index.jsp?error=Usuario o Clave Incorrecta");     
           }      
        }              
%>
