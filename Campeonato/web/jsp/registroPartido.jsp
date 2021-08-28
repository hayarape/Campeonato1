<%-- 
    Document   : registro
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page import="java.util.Date"%>
<%@page import="unba.mundo.dto.*"%>
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
        <%  HttpSession s =request.getSession();
            String accion1=request.getParameter("accion1"); 
            
            if(accion1!=null){
                if(accion1.equals("registro")){
                
                    String strFecha=request.getParameter("fecha"); 
                    System.out.println(strFecha);
                    String strEquipoLocal=request.getParameter("equipolocal"); 
                    String strEquipoVisitante=request.getParameter("equipoVisitante");
                    String Goles_Local=request.getParameter("GolesEquiLocal"); 
                    String Goles_Visita=request.getParameter("GolesEquiVisi");
                    String User=s.getAttribute("usuario").toString();
                    String Clave=s.getAttribute("clave").toString();
                    
                    int golLocal=0;
                    int golVisi=0;     
                    if( !Goles_Local.equals("") && !Goles_Visita.equals("") )
                    {
                    golLocal=Integer.parseInt(Goles_Local.trim());
                    golVisi=Integer.parseInt(Goles_Visita.trim());
                    }
                  
                    
                    String[] strf=strFecha.split("-");
                    int dia=Integer.parseInt(strf[2]);
                    int mes=Integer.parseInt(strf[1]);
                    int anio=Integer.parseInt(strf[0]);
                    
                    Equipo Local=fachada.getEquipos().get(fachada.getEquipos().indexOf(new Equipo(strEquipoLocal, "")));
                    Equipo Visi=fachada.getEquipos().get(fachada.getEquipos().indexOf(new Equipo(strEquipoVisitante, "")));
                    
                    Usuario u=fachada.getUsuarios().get(fachada.getUsuarios().indexOf(new Usuario("", "", User, Clave)));
                    
                    Partido p = new Partido(new Date(anio, mes, dia), golLocal, golVisi, Local, Visi, u);
                    if(fachada.registrarPartido(p)){
                        response.sendRedirect("menu.jsp");}
                    
                }
            }
            String equipoVisitante=" <select name='equipoVisitante' size='1' required>";
                    
            String equipoLocal=" <select name='equipolocal' size='1' required>";
            
                    for(Equipo e:fachada.getEquipos()){
                    equipoLocal+="<option value='"+e.getNombre()+"'>"+e.getNombre()+"</option>";
                    equipoVisitante+="<option value='"+e.getNombre()+"'>"+e.getNombre()+"</option>";   
                    }
                    
                    equipoLocal+="</select>";
                    equipoVisitante+="</select>";
             
        %>
        
               <form name="registro" action="?">         
                    <div class="espacio"></div>
                    <label class="texto">Fecha:</label>
                    <p><input class="campo" type="date" name="fecha" value="" required/></p>
                    <div class="espacio"></div>
                    <label class="texto">Equipo Local:</label>
                    <p><%=equipoLocal%></p>
                     <div class="espacio"></div>
                    <label class="texto">Equipo Visitante:</label>
                    <p><%=equipoVisitante%></p>
                     <div class="espacio"></div>
                    <label class="texto">Goles Equipo Local:</label>
                    <p><input class="campo" type="text" name="GolesEquiLocal" value="" /></p>   
                    <label class="texto">Goles Equipo Visitante:</label>
                    <p><input class="campo" type="text" name="GolesEquiVisi" value="" /></p>
                    <input id="accion1" name="accion1" type="hidden" value="registro">
                    <input id="boton" type="submit" value="REGISTRAR" name="REGISTRAR" />                   
                </form>

    </body>
</html>

