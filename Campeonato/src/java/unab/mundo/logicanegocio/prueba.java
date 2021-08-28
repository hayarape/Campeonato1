/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.logicanegocio;

import static java.time.Clock.system;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import unab.mundo.dao.Equipo_DAO;
import unab.mundo.dao.Partido_DAO;
import unab.mundo.dao.Usuario_DAO;
import unab.mundo.facade.Campeonato_facade;
import unba.mundo.dto.Equipo;
import unba.mundo.dto.Partido;
import unba.mundo.dto.Usuario;

/**
 *
 * @author YAMID
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
     /*   String r="asdasdasdasd\nsdasdasd\nadsadasd";
        JOptionPane.showMessageDialog(null,r,"Alerta",1); */
        //JOptionPane.showConfirmDialog(null,"no sirve","titulo",0);
        //JOptionPane.showInputDialog("meta algo");
     //   JOptionPane.showMessageDialog(null,"no sirve","Alerta",1);
     //partidos
     /** ArrayList<Partido> partidos =new Partido_DAO().cargarpartidos();
      for(Partido p: partidos){
      System.out.println(p.toString());
      System.out.println("\n");
      System.out.println("equi local: "+p.getEqui_local().toString());
      System.out.println("equi local: "+p.getEqui_Visitante().toString());
      System.out.println("\n");
      }
    }*/
    
     //equipos
    /* ArrayList<Equipo> e =new Equipo_DAO().cargarEquipos();
      for(Equipo e1: e)
      System.out.println(e1.getNombre()+","+e1.getN_entrenador()+"\n");
    }
     */
    //System.out.println(new Admin_Campeonato().VerResultados());

   /** Partido p=new Partido(Calendar.getInstance().getTime(), 5, 5, new Equipo("UIS",""), new Equipo("UDES",""),new Usuario());
     
    System.out.println(new Campeonato_facade().registrarPartido(p));*/
    /**ArrayList<Partido> lista=new Partido_DAO().cargarpartidos();
    for(Partido p:lista)
    System.out.println(p.toString());**/
    
    //Boolean f=new Campeonato_facade().registrarUsuario("harol", "harol", "harol", "harol");
    
    
     Admin_Campeonato ac= new Admin_Campeonato(); 
    
     for(Partido p:ac.getPartidos())
      System.out.println(p.toString());
          
     Equipo Local=ac.getEquipos().get(ac.getEquipos().indexOf(new Equipo("UIS", "")));
     Equipo Visi=ac.getEquipos().get(ac.getEquipos().indexOf(new Equipo("UNAB", "")));
                    
     Boolean f=new Campeonato_facade().actualizarPartido(new Partido(new Date(2021,04,22), 30, 30, Local, Visi, null));
    }
}
