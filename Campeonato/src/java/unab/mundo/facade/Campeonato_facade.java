/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.facade;

import java.util.ArrayList;
import unab.mundo.logicanegocio.*;
import unba.mundo.dto.*;

/**
 *
 * @author YAMID
 */
public class Campeonato_facade {
    Admin_Campeonato ac ;
   
    public Campeonato_facade() {
        ac=new Admin_Campeonato() ;
    }
    
    public Boolean actualizarPartido(Partido p){
     return ac.actualizarPartido(p);
    }
    
    public ArrayList<Usuario> getUsuarios(){
    return ac.getUsuarios();
    }
    
    public boolean registrarUsuario(String nombre,String correo,String usuario, String clave){
        return ac.registrarUsuario(nombre, correo, usuario, clave);
    }
    
    public boolean iniciarSesion(String user, String pass){
        return ac.iniciarSesion(user, pass);
    }
    
    public boolean registrarPartido(Partido p){
        return ac.registrarPartido(p);
    }
    
    public ArrayList<Partido> getPartidos(){
        return ac.getPartidos();
    }
        
    public ArrayList<Equipo> getEquipos() {
        return ac.getEquipos();
    }
    
    public Campeonato_facade(Admin_Campeonato ac) {
        this.ac = ac;
    }
    
    public String VerResultados(){
        return ac.VerResultados();
    }
    
    public String ListarEquipos(){
        return ac.ListarEquipos();
    }
    
}
