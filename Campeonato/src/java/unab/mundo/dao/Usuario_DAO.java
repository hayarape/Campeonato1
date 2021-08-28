/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.mundo.dao;

import java.util.ArrayList;
import unab.util.BaseDeDatos;
import unba.mundo.dto.Usuario;

/**
 *
 * @author YAMID
 */
public class Usuario_DAO {

    public Usuario_DAO() {
         BaseDeDatos.conectar(); 
    }
    /*
    public boolean iniciarSersion(String username,String password){
          String sql="select * from usuario where username='"+username+"' and password='"+password+"'";
          ArrayList<String>l1=BaseDeDatos.getConsultaSQL(sql);
          return !l1.isEmpty();
    }*/
     public boolean registrarUsuario(String nombre,String correo,String usuario, String clave){
         String sql=" INSERT INTO `usuario`(`username`, `password`, `nombre`, `correo`) VALUES ('"+usuario+"','"+clave+"','"+nombre+"','"+correo+"')";
         return (BaseDeDatos.ejecutarActualizacionSQL(sql));
     }
    public Usuario cargarUsuario(String id){
    
          String sql="select * from usuario where id_user="+id;
          ArrayList<String>l1=BaseDeDatos.getConsultaSQL(sql);
          String [] cadena=l1.get(0).split(";");
          Usuario u=new Usuario(cadena[3], cadena[4], cadena[1], cadena[2]);
          return u;
    }
    
    public ArrayList<Usuario> cargarUsuarios() {
      
          String sql="select * from usuario ";
          ArrayList<String>l1=BaseDeDatos.getConsultaSQL(sql);
          ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
          
          for (String user:l1){
          
          String [] cadena=user.split(";");
          Usuario u=new Usuario(cadena[3], cadena[4], cadena[1], cadena[2]);
          usuarios.add(u);
          }
           return usuarios;
    }
    
    
}
