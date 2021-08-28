/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.logicanegocio;

import java.util.ArrayList;
import unba.mundo.dto.*;
import unab.mundo.dao.*;
/**
 *
 * @author YAMID
 */
public class Admin_Campeonato {
   private ArrayList<Partido> partidos;
   private ArrayList<Equipo> equipos;
   private ArrayList<Usuario> usuarios;

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
   
    public Boolean actualizarPartido(Partido p){
           int pos = partidos.indexOf(p);
           System.out.println("posicion: "+pos);
        if(new Partido_DAO().actualizarPartido(p)){
            partidos.get(pos).setGoles_equi_Visitante(p.getGoles_equi_Visitante());
            partidos.get(pos).setGoles_equi_local(p.getGoles_equi_local());
            return true;
        }
        return false;
    }
    
    public Admin_Campeonato() {
        this.partidos =new Partido_DAO().cargarpartidos();
        this.equipos=new Equipo_DAO().cargarEquipos();
        this.usuarios=new Usuario_DAO().cargarUsuarios();
    }

     public boolean registrarUsuario(String nombre,String correo,String usuario, String clave){
         boolean confirmacion=new Usuario_DAO().registrarUsuario(nombre, correo, usuario, clave);
        if(confirmacion) this.usuarios.add(new Usuario(nombre, correo, usuario,clave));
        return confirmacion; 
     }
    
    public boolean iniciarSesion(String user, String pass){
     return usuarios.indexOf(new Usuario("", "", user, pass))>=0?true:false;
    }
    
    public boolean registrarPartido(Partido p){
       if (new Partido_DAO().registrarPartido(p))
       {
           partidos.add(p);
           return true;
       }else 
           return false;
    }
    
    public String VerResultados(){
        String msg="";
        for(Partido p: partidos)
        msg+=p.toString();
        return msg;
    }
    
    public String ListarEquipos(){
        String msg="";
        for(Equipo e:equipos)
            msg+= e.toString()+"\n";
        return msg;
    }
    
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    private Object Partido_DAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
   
}
