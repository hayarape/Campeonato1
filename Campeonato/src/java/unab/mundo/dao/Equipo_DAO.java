/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.dao;

import java.util.ArrayList;
import unab.util.BaseDeDatos;
import unba.mundo.dto.Equipo;

/**
 *
 * @author YAMID
 */
public class Equipo_DAO {

    public Equipo_DAO() {
        BaseDeDatos.conectar(); 
    }

    
    public Equipo cargarEquipo(String id) {
          String sql="select * from equipo where id="+id;
          ArrayList<String>l1=BaseDeDatos.getConsultaSQL(sql);
          String [] cadena=l1.get(0).split(";");
          Equipo e=new Equipo(cadena[1], cadena[2]);
          return e;
    }

    public ArrayList<Equipo> cargarEquipos() {
       ArrayList<Equipo> e =new ArrayList<Equipo>();
       String sql="select * from equipo";
       
       ArrayList<String> lista= BaseDeDatos.getConsultaSQL(sql);
       if(lista==null || lista.isEmpty())
       return e;
             
       String[]item;
       for(String cadenaE: lista)
       {  item=cadenaE.split(";");
          Equipo e1= new Equipo(item[1], item[2]);
          e.add(e1);
       }
       return e;
    }
    
    
    
}
