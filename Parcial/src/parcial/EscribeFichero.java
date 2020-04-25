package estructuras;

/*
Nombre: Julián David Acosta Ramirez.
Código: 1000252139.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EscribeFichero {
    
    /*
    
    FileReader: Permite la lectura de ficheros. Se usa el método read.
    BufferedReader: Lee el texto de una secuencia de entrada almacenado en el
    bufer de caracteres. En el caso de este ejercicio, se leen las lineas que
    tenga el .txt.
    
    El código tal y como se explicó en las definiciones anteriores, lee lo que 
    se encuentre en el fichero con la ruta que se especifica al inicio, para
    posteriormente imprimirlo en consola. Para este caso imprimió:
    
    Linea 0
    Linea 1
    Linea 2
    Linea 3
    Linea 4
    Linea 5
    Linea 6
    Linea 7
    Linea 8
    Linea 9
    
    */
    
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File ("C:\\datos\\prueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            //Lectura del Fichero
            String linea;
            while((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fr) {
                    fr.close();
                }
            } catch(Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
}
