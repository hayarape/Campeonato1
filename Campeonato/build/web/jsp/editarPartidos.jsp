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
            
            String camposocultos="";
            /* String accion1=request.getParameter("accion1");
            String accion=request.getParameter("accion");
           
            if(accion!=null){
              if(accion.equals("verpartidos")){
              response.sendRedirect("formValidar.jsp");
              }
            }
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
                        
                        camposocultos="&nbsp";
                        //s.setAttribute("editar", "1");
                        //response.addHeader("accion3", "1234");
                        //response.setHeader("accion", "vacio");
                        //response.reset();
                        response.sendRedirect("?accion=verpartidos");
                    }
               // }
            } */
            String fecha=request.getParameter("fecha"); 
            String equilocal=request.getParameter("equilocal"); 
            String equivisi=request.getParameter("equivisi"); 
            String goleslocal=request.getParameter("goleslocal"); 
            String golesvisi=request.getParameter("golesvisi");  
            
            String selectEquiLocal= " <select name='equipolocal' size='1' required >"+
                        "<option value='"+equilocal+"'>"+equilocal+"</option>"+
                        "</select>";
            String selectequipoVisitante= " <select name='equipoVisitante' size='1' required>"+
                    "<option value='"+equivisi+"'>"+equivisi+"</option>"+
                        "</select>";
            
            camposocultos="<input id='accion1' name='accion1' type='hidden' value='editar'>"+
                    "<input id='accion' name='accion' type='hidden' value='editarpartido'>";
            s.setAttribute("editar", null);
        %>
        
               <form name="registro" action="editar.jsp">         
                    <div class="espacio"></div>
                    <label class="texto">Fecha:</label>
                    <p><input class="campo" type="date" name="fecha" value="<%=fecha%>" required /></p>
                    <div class="espacio"></div>
                    <label class="texto">Equipo Local:</label>
                    <p><%=selectEquiLocal%></p>
                     <div class="espacio"></div>
                    <label class="texto">Equipo Visitante:</label>
                    <p><%=selectequipoVisitante%></p>
                     <div class="espacio"></div>
                    <label class="texto">Goles Equipo Local:</label>
                    <p><input class="campo" type="text" name="GolesEquiLocal" value="<%=goleslocal%>" /></p>   
                    <label class="texto">Goles Equipo Visitante:</label>
                    <p><input class="campo" type="text" name="GolesEquiVisi" value="<%=golesvisi%>" /></p>
                    <%=camposocultos%>
                    <input id="boton" type="submit" value="EDITAR" name="EDITAR" />                   
                </form>

    </body>
</html>

