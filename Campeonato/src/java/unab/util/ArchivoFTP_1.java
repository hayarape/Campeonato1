/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unab.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;


public class ArchivoFTP_1 {

    private static FTPClient ftp = null;
    private static FileInputStream fis = null;
    private static FileOutputStream fos = null;

    private static String ip = "sandbox1.ufps.edu.co";
    private static String user = "ejemplo";
    private static String pass = "ufps";
    private static String localFile = "/home/connors/Escritorio/jaja.txt";
    private static String hostFile="/jaja.txt";

  public static void main(String[] args) throws SocketException, IOException {

      conectar(ip,user,pass);
      enviarArchivoFTP(localFile, hostFile);
      desconectar();

  }
  public static void conectar(String ip, String user, String pass) throws SocketException, IOException{
   ftp = new FTPClient();
    ftp.connect(ip);

    if(ftp.login(user, pass)){
        System.out.println("login OK");
    }else
          System.out.println("login Error");
  }
  public static void desconectar() throws IOException{
      ftp.logout();
    ftp.disconnect();
  }


  public static void enviarArchivoFTP(String localFile, String hostFile) throws FileNotFoundException, IOException{
    fis = new FileInputStream(localFile);

    if(ftp.storeFile(hostFile,fis)){
        System.out.println("Envio correcto");
    }else
        System.out.println("Error Envio ");
    fis.close();
  }

}