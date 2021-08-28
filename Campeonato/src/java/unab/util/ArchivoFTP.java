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
import org.apache.commons.net.ftp.FTPFile;


public class ArchivoFTP {

    private static FTPClient ftp = null;
    private static FileInputStream fis = null;
    private static FileOutputStream fos = null;

    private static String ip = "sandbox1.ufps.edu.co";
    private static String user = "ejemplo";
    private static String pass = "ufps";
    private static String localFile = "/home/connors/Escritorio/jaja.txt";
    private static String hostFile="/pato/jaja.txt";

  public static void main(String[] args) throws SocketException, IOException {
    /**
      conectar(ip,user,pass);
      directorioActual();
      cambiarDeDirectorioEnFTP("Savs");
      directorioActual();
      cambiarDirectorioAnterior();
      directorioActual();
      lista();
      enviarArchivoFTP(localFile, hostFile);
      desconectar();*/

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
  public static void directorioActual() throws IOException{
      System.out.println( ftp.printWorkingDirectory());
  }
  public static void cambiarDeDirectorioEnFTP(String dir) throws IOException{
      ftp.changeWorkingDirectory(dir);
  }
  public static void cambiarDirectorioAnterior() throws IOException{
      ftp.changeToParentDirectory();
  }

  public static void enviarArchivoFTP(String localFile, String hostFile) throws FileNotFoundException, IOException{
    fis = new FileInputStream(localFile);

    if(ftp.storeFile(hostFile,fis)){
        System.out.println("Envio correcto");
    }else
        System.out.println("Error Envio ");
    fis.close();
  }

  public static void desrcargarArchivoFTP(String localFile, String hostFile) throws FileNotFoundException, IOException{

//    fos = new FileOutputStream("upload.txt");
    fos = new FileOutputStream(localFile);
    if(ftp.retrieveFile("/" + hostFile, fos)){
        System.out.println("Desgarca correcta");
    }else
          System.out.println("Error Descarga");
    fos.close();
  }

  public static void eliminarArchivoFTP() throws IOException{

//      String hostFile = "Hola2.txt";
    boolean deleted = ftp.deleteFile(hostFile);
    if (deleted) {
      System.out.println("File deleted...");
    }else
          System.out.println("Error al borrar");
  }

  public static void listaArchivos() throws IOException{

    FTPFile[] ftpFiles = ftp.listFiles();
    for (FTPFile ftpFile : ftpFiles) {
      // Check if FTPFile is a regular file
      if (ftpFile.getType() == FTPFile.FILE_TYPE) {
//        System.out.println("FTPFile: " + ftpFile.getName() + "; "  + ftpFile.getSize()/1024 + " Kbs");
        System.out.println("FTPFile: " + ftpFile.getName() + "; "  + ftpFile.getSize() + " b");
//        System.out.println("FTPFile: " + ftpFile.getName() + "; " );
      }
    }
  }

  /**
  public static void listaDirectorios() throws IOException{

    FTPFile[] ftpFiles = ftp.listDirectories();
    for (FTPFile ftpFile : ftpFiles) {
      // Check if FTPFile is a regular file
      if (ftpFile.getType() == FTPFile.FILE_TYPE) {
//        System.out.println("FTPFile: " + ftpFile.getName() + "; "  + ftpFile.getSize()/1024 + " Kbs");
        System.out.println("FTPFile: " + ftpFile.getName() + "; "  + ftpFile.getSize() + " b");
//        System.out.println("FTPFile: " + ftpFile.getName() + "; " );
      }
    }
  }
   */

  public static void lista() throws IOException{
  String[] names = ftp.listNames();
    for (String name : names) {
      System.out.println("Name = " + name);
    }
  }
}