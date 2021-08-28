/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unab.util;
import java.io.*;
import java.net.MalformedURLException;
import org.apache.commons.net.ftp.FTPClient;


/**
 *
 * @author darking
 */
public class SubirArchivoFTP {

    //Almacena la dirección URL del archivo
    private String direccion;
    private String usuario;
    private String clave;
    private String path;
    private FTPClient url=null;
    
    public SubirArchivoFTP() {
    }

    public SubirArchivoFTP(String direccion, String usuario, String clave, String path) {
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
        this.path = path;
    }

    public String getClave() {
        return clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPath() {
        return path;
    }

    public String getUsuario() {
        return usuario;
    }

    public FTPClient getUrl() {
        return url;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setUrl(FTPClient url) {
        this.url = url;
    }
    
    private void Conectar(){
        
        try{
        
            this.setUrl(new FTPClient());

            this.getUrl().connect(this.getDireccion());
            if(this.getUrl().login(this.getUsuario(), this.getClave()))
            {
                this.getUrl().enterLocalActiveMode();
                System.out.println("login correcto ");
            }else System.out.println("login incorrecto");
        
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public boolean subir(String cadena){
        this.Conectar();
        java.util.ArrayList<String> l=new java.util.ArrayList<String>();
        File archivo=new File("datos.txt");
        String inputText="";
       
        try {
               /* URL url = new URL("http://"+this.getDireccion()+"/~"+this.getUsuario()+"/datos/datos.txt");
                                
                BufferedReader in = null;
		   
		try {
		     // Volcamos lo recibido al buffer
		     in = new BufferedReader(new InputStreamReader(
		     url.openStream()));
		      } catch(Throwable t){}

		// Transformamos el contenido del buffer a texto
                
                String inputLine;
		String inputText="";

		// Mientras haya cosas en el buffer las volcamos a las
		// cadenas de texto 
		while ((inputLine = in.readLine()) != null)
		      inputText+=inputLine+"\n";*/
                
                inputText+=cadena;
                
                //in.close();
                
                archivo.createNewFile();
                
                BufferedWriter write=new BufferedWriter(new FileWriter(archivo));
                write.write(inputText);
                write.close();      
                
                this.enviarArchivoFTP("datos.txt");
            }catch (MalformedURLException ex1) {
		      System.out.println("URL erronea: "+ex1.getMessage());
		    } catch (IOException ioe) {
                            System.out.println("IOException: " + ioe);
                return false;
                }
        
        return true;
    }
    
    private void enviarArchivoFTP(String localFile) throws FileNotFoundException, IOException{
    
    FileInputStream fis = new FileInputStream(localFile);

    if(this.getUrl().storeFile(this.getPath(), fis)){
        
        System.out.println("Envio correcto");
    }else
        System.out.println("Error Envio ");
    
    fis.close();    
  }
}
