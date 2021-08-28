<%-- 
    Document   : registro
    Created on : 22/08/2021, 01:42:33 PM
    Author     : YAMID
--%>

<%@page import="java.util.ArrayList"%>
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
            
            ArrayList<Partido> Lista_Partidos = fachada.getPartidos();
                    
            String srtPartidos="<header class='cabeceraSubContenidos'>\n"+
                  "<b>PARTIDOS ("+Lista_Partidos.size()+")</b>\n"+
                  "</header>\n"+
                  "<br>\n"+
                   "<section class='subcontenido'>\n"+
                   "<table id='contenidoResultado' border='1' width='100%'>\n"+
                   "<tr id='cabeceraListado'>\n"+
                   "<td>Partidos</td><td>Accion</td>\n"+
                   "</tr>\n";
                   for(Partido p:Lista_Partidos){
                   String mes=p.getFecha().getMonth()<10? "0"+p.getFecha().getMonth():p.getFecha().getMonth()+"";
                   String dias=p.getFecha().getDate()<10? "0"+p.getFecha().getDate():p.getFecha().getDate()+"";
                   String fecha=p.getFecha().getYear()+"-"+mes+"-"+dias;
                   srtPartidos+="<tr><td>"+p.toString()+"</td>"+
                   "<td align='center'><a href='menu.jsp?accion=editarpartido&goleslocal="+p.getGoles_equi_local()+"&golesvisi="+p.getGoles_equi_local()+"&fecha="+fecha+"&equilocal="+p.getEqui_local().getNombre()+"&equivisi="+p.getEqui_Visitante().getNombre()+"'><img src='../imagenes/Editar1.png' width='24' height='24'/></a></td></tr>";
                   }    
                    srtPartidos+="</table>\n</section>";
        
        %>
              <%=srtPartidos%></p>
                     
    </body>
</html>

