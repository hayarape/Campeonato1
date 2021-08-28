/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unab.util;
import java.sql.*;





/**
 *Clase que permite conectar con una Base De datos Mysql; sin embargo,
 * con solo cambiar el atributo controlador puede usarse para cualquier motor de base de datos
 * @author Yamid
 */
public class BaseDeDatos {
//private static  String bd = "sandbox";
//private static  String login = "ejemplo";
//private static  String password = "ufps";
//private static  String url = "jdbc:postgresql://sandbox1.ufps.edu.co/"+bd;
//private static  String controlador="org.postgresql.Driver";
//private static  JDBCMiddler jdbc;

private static  String bd = "campeonato";
private static  String login = "root";
private static  String password = "12345678";
private static  String url = "jdbc:mysql://localhost:3306/"+bd;
private static  String controlador="com.mysql.jdbc.Driver";
private static  JDBCMiddler jdbc;

public static boolean hayConexion()
{
        return (jdbc!=null && jdbc.hayConexion());
}

    
 public static  void conectar()
    {
        jdbc=new JDBCMiddler(controlador,url,login,password);
        try{
        jdbc.conectar();
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

public  static boolean ejecutarActualizacionSQL(String comandoSQL)
{
    try{
        return (jdbc.ejecutarActualizacionSQL(comandoSQL));
    }catch(Exception e)
    {
            System.err.println("SQL Error:"+e.getMessage());
            return (false);
    }
}

public  static void desconectar()
{
try{
        jdbc.desconectar();
    }catch(Exception e)
    {
            System.err.println("SQL Error:"+e.getMessage());
        
    }
}


public  static String getTablaHTML(String sql)
{
try{
        return (jdbc.getHTML(sql));
    }catch(Exception e)
    {
            System.err.println("SQL Error:"+e.getMessage());
            return ("No se pudo crear la tabla");
    }


}


public  static ResultSet ejecutarSQL(String consultaSQL)
{
    try{
        return (jdbc.ejecutarSQL(consultaSQL));
    }catch(Exception e)
    {
            System.err.println("SQL Error:"+e.getMessage());
            return (null);
    }

}


public static java.util.ArrayList<String>  getConsultaSQL(String sql)
{
try{
        return (jdbc.getSQL(sql));
    }catch(Exception e)
    {
            System.err.println("SQL Error:"+e.getMessage());
            return (null);
    }
    

}

public static void main(String args[])
{
if(BaseDeDatos.hayConexion())
    System.out.println("Hay conexion");
else
{
       System.out.println("No Hay conexion");
    BaseDeDatos.conectar();
}
System.out.println(BaseDeDatos.getTablaHTML("SELECT * FROM usuario"));


}




}
