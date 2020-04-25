//Brayan Urbina
//1013678727
package parcial;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author b_urb
 */
public class codigo3 {
    public static void main(String[] args) throws IOException{
        File ruta = new File("c:\\1eval");
        File f = new File(ruta,"salida.txt");
        String dirActual = System.getProperty("user.dir");
        if(!f.exists()){
            System.out.println("Fichero "+f.getName()+" no existe");
            if (!ruta.exists()) {
                System.out.println("El directorio "+ ruta.getName()+" no existe");
                if (ruta.mkdir()) {
                    System.out.println("Directorio creado");
                    if (f.createNewFile()) {
                        System.out.println("Fichero "+f.getName()+" creado");
                    }else{
                        System.out.println("No se ha podido crear "+ f.getName());
                    }
                }else{
                    System.out.println("No se ha podido crear"+ ruta.getName());
                }
            }else{
                if (f.createNewFile()) {
                    System.out.println("Fichero"+f.getName()+" creado");
                }else{
                    System.out.println("No se ha podidio crear "+ f.getName());
                }
            }
        
        
        }else{
            System.out.println("Fichero "+f.getName()+" existe");
            System.out.println("Tamaño "+f.length()+" bytes");
        }
        FileReader ficheroEntrada = null;
        FileWriter fichero = null;
        PrintWriter pw=null;
        try {
            ficheroEntrada = new FileReader("C:\\datos\\entrada.txt");
            fichero = new FileWriter("C:\\datos\\salida.txt");
     
            pw = new PrintWriter(fichero);
            
            for (int i = 0; i < 10; i++) {
                pw.println("Linea "+i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(null!=fichero){
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
