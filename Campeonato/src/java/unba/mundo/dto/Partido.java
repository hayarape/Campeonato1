/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unba.mundo.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author YAMID
 */
public class Partido {
   private Date fecha; 
   private int goles_equi_local;
   private int goles_equi_Visitante;
   private Equipo equi_local;
   private Equipo equi_Visitante;
   private Usuario usuario;

    public Partido() {
    }

    public Partido(Date fecha, int goles_equi_local, int goles_equi_Visitante, Equipo equi_local, Equipo equi_Visitante, Usuario usuario) {
        this.fecha = fecha;
        this.goles_equi_local = goles_equi_local;
        this.goles_equi_Visitante = goles_equi_Visitante;
        this.equi_local = equi_local;
        this.equi_Visitante = equi_Visitante;
        this.usuario=usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setGoles_equi_local(int goles_equi_local) {
        this.goles_equi_local = goles_equi_local;
    }

    public void setGoles_equi_Visitante(int goles_equi_Visitante) {
        this.goles_equi_Visitante = goles_equi_Visitante;
    }

    public void setEqui_local(Equipo equi_local) {
        this.equi_local = equi_local;
    }

    public void setEqui_Visitante(Equipo equi_Visitante) {
        this.equi_Visitante = equi_Visitante;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public Date getFecha() {
        return fecha;
    }

    public int getGoles_equi_local() {
        return goles_equi_local;
    }

    public int getGoles_equi_Visitante() {
        return goles_equi_Visitante;
    }

    public Equipo getEqui_local() {
        return equi_local;
    }

    public Equipo getEqui_Visitante() {
        return equi_Visitante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.fecha);
        hash = 47 * hash + Objects.hashCode(this.equi_local);
        hash = 47 * hash + Objects.hashCode(this.equi_Visitante);
        return hash;
    }

  /**
    public boolean equals(Partido P) {
    
        
        
        if (this.equi_local.getNombre().equals(P.getEqui_local().getNombre()) && this.equi_Visitante.getNombre().equals(P.getEqui_Visitante().getNombre())) 
        {
            return true;
        }
        return false;
        
    }**/


    public String toString() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String fechaatr = sdf.format(this.getFecha());
        return  fecha.getDate()+"-"+fecha.getMonth()+"-"+fecha.getYear()+"    "+ this.equi_local.getNombre()+ " ("+this.goles_equi_local+") VS ("+this.goles_equi_Visitante+") "+this.equi_Visitante.getNombre()+"\n";
        //return  fechaatr+" - "+ this.equi_local.getNombre()+ " ("+this.goles_equi_local+") VS ("+this.goles_equi_Visitante+") "+this.equi_Visitante.getNombre()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
         
        if (this.fecha.getDate()!= other.fecha.getDate() || this.fecha.getMonth()!= other.fecha.getMonth() || this.fecha.getYear()!= other.fecha.getYear()) {
          
            return false;
        }
        if (!Objects.equals(this.equi_local, other.equi_local)) {
            return false;
        }
        if (!Objects.equals(this.equi_Visitante, other.equi_Visitante)) {
            return false;
        }
        return true;
    }
     
}
 