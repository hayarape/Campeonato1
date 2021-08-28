<%-- 
    Document   : validar
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page import="java.util.Date"%>
<%@page import="unba.mundo.dto.Partido"%>
<%@page import="unba.mundo.dto.Equipo"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<jsp:useBean id="fachada" scope="application" class="unab.mundo.facade.Campeonato_facade" />
<jsp:useBean id="usuario" class="unba.mundo.dto.Usuario" />
         
        
<%      //recibe parametros usuario y clave
        HttpSession s=request.getSession();
        
        if(s.getAttribute("valido").toString().equals("true")){
       
            String accion1=request.getParameter("accion1");
           
           
            if(accion1!=null){
                //if(accion1.equals("editar")){
                    String strFecha=request.getParameter("fecha"); 
                    String Goles_Local=request.getParameter("GolesEquiLocal"); 
                    String Goles_Visita=request.getParameter("GolesEquiVisi");
                    String User=s.getAttribute("usuario").toString();
                    String Clave=s.getAttribute("clave").toString();
                    String strEquipoLocal=request.getParameter("equipolocal"); 
                    String strEquipoVisitante=request.getParameter("equipoVisitante");
                    
                    String[] strf=strFecha.split("-");
                    int dia=Integer.parseInt(strf[2]);
                    int mes=Integer.parseInt(strf[1]);
                    int anio=Integer.parseInt(strf[0]);
                    
                    int golLocal=0;
                    int golVisi=0;     
                    if( !Goles_Local.equals("") && !Goles_Visita.equals("") )
                    {
                    golLocal=Integer.parseInt(Goles_Local.trim());
                    golVisi=Integer.parseInt(Goles_Visita.trim());
                    }
                     
                    Equipo Local=fachada.getEquipos().get(fachada.getEquipos().indexOf(new Equipo(strEquipoLocal, "")));
                    Equipo Visi=fachada.getEquipos().get(fachada.getEquipos().indexOf(new Equipo(strEquipoVisitante, "")));
               
                    Partido p = new Partido(new Date(anio, mes, dia), golLocal , golVisi, Local, Visi, null);
                    
                    if(fachada.actualizarPartido(p)){
                        
                        response.sendRedirect("menu.jsp");
                    }
               // }
            }   
            
           
        }              
%>
