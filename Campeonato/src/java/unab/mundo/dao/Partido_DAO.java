/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import unab.util.BaseDeDatos;
import unba.mundo.dto.*;

/**
 *
 * @author YAMID
 */
public class Partido_DAO {

    public Partido_DAO() {
        BaseDeDatos.conectar(); 
    }
    
    public boolean actualizarPartido(Partido p){
    
    String sqllocal="select id from equipo where nombre='"+p.getEqui_local().getNombre()+"'";
    //System.out.println(sqllocal);
    ArrayList<String> rsLocal=BaseDeDatos.getConsultaSQL(sqllocal);
    String idEquiLocal=rsLocal.get(0).split(";")[0];
    
    String sqlvisitante="select id from equipo where nombre='"+p.getEqui_Visitante().getNombre()+"'"; 
    ArrayList<String> rsVisi=BaseDeDatos.getConsultaSQL(sqlvisitante);
    String idEquiVisitante=rsVisi.get(0).split(";")[0];
    
    String mes=p.getFecha().getMonth()<10? "0"+p.getFecha().getMonth():p.getFecha().getMonth()+"";
    String dias=p.getFecha().getDate()<10? "0"+p.getFecha().getDate():p.getFecha().getDate()+"";
    String fecha=p.getFecha().getYear()+"-"+mes+"-"+dias;
    
    String sql="update partido set goles_equi_local="+p.getGoles_equi_local()+" , goles_equi_visi="+p.getGoles_equi_Visitante()+" where fecha='"+fecha+"' and id_equipolocal="+idEquiLocal+" and id_equipovisitante="+idEquiVisitante;
    //System.out.println(sql);
    return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
    
    public ArrayList<Partido> cargarpartidos (){
    ArrayList<Partido> p = new ArrayList<Partido>();
    
    String sql="SELECT * FROM partido";
    ArrayList<String> cadena=BaseDeDatos.getConsultaSQL(sql);
    if(cadena.isEmpty()|| cadena==null){
     return p;
    }
    String [] lista=null;
    for(String item: cadena){
        lista=item.split(";");
        String dat[]=lista[1].split("-");
        System.out.println(dat[2]+","+dat[1]+","+dat[0]);
        //Date fecha=new Date(Integer.parseInt(dat[0]),Integer.parseInt(dat[1]),Integer.parseInt(dat[2]));
        //System.out.println(fecha.toString());
        Date fecha = new Date();
        fecha.setYear(Integer.parseInt(dat[0]));
        fecha.setMonth(Integer.parseInt(dat[1]));
        fecha.setDate(Integer.parseInt(dat[2]));
        
        Equipo equilocal=new Equipo_DAO().cargarEquipo(lista[2]);
        Equipo equivisi=new Equipo_DAO().cargarEquipo(lista[3]);
        int gollocal=Integer.parseInt(lista[4]);
        int golvisita=Integer.parseInt(lista[5]);
        Usuario newUser=new Usuario_DAO().cargarUsuario(lista[6]);
        Partido nuevo= new Partido(fecha, gollocal, golvisita, equilocal, equivisi,newUser);
        p.add(nuevo);
    }
    return p;
    }
    
    public boolean registrarPartido(Partido p){
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //String fecha = sdf.format(p.getFecha());
    String fecha =p.getFecha().getYear()+"-"+p.getFecha().getMonth()+"-"+p.getFecha().getDate();
    //String fecha=p.getFecha().getYear()+"-"+p.getFecha().getMonth()+"-"+p.getFecha().getDate();
    String sql1="SELECT id FROM equipo WHERE nombre='"+p.getEqui_local().getNombre()+"'";
    ArrayList<String> cadena=BaseDeDatos.getConsultaSQL(sql1);
    String rs1=cadena.get(0).split(";")[0];
    String sql2="SELECT id FROM equipo WHERE nombre='"+p.getEqui_Visitante().getNombre()+"'";
    ArrayList<String> cadena1=BaseDeDatos.getConsultaSQL(sql2);
    String rs2=cadena1.get(0).split(";")[0];
    
    String sql3="SELECT id_user FROM usuario WHERE username='"+p.getUsuario().getUsername()+"' and password='"+p.getUsuario().getPassword()+"'";
    System.out.println(sql3);
    ArrayList<String> cadena2=BaseDeDatos.getConsultaSQL(sql3);
    String rs3=cadena2.get(0).split(";")[0];
    
    String sql="insert into partido (fecha,id_equipolocal,id_equipovisitante,goles_equi_local,goles_equi_visi,id_usuario) values ('"+fecha+"',"+rs1+","+rs2+","+p.getGoles_equi_local()+","+p.getGoles_equi_Visitante()+","+rs3+")";
    System.out.println(sql);
    return (BaseDeDatos.ejecutarActualizacionSQL(sql));
    }
      
}
