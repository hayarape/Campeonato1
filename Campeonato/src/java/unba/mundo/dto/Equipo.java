/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unba.mundo.dto;

import java.util.Objects;


/**
 *
 * @author YAMID
 */
public class Equipo {
    
    private String nombre;
    private String n_entrenador;

    public Equipo() {
    }

    public Equipo(String nombre, String n_entrenador) {
        this.nombre = nombre;
        this.n_entrenador = n_entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getN_entrenador() {
        return n_entrenador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setN_entrenador(String n_entrenador) {
        this.n_entrenador = n_entrenador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        return hash;
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
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
}
