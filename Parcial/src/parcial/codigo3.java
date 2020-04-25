//Brayan Urbina
//1013678727
package parcial;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author b_urb
 */
public class codigo3 {
    public static void main(String[] args){
        FileWriter fichero = null;
        PrintWriter pw=null;
        try {
//            Se indica cual es el archivo que se va editar con FileWriter y se abre con FileWriter
            fichero = new FileWriter("C:\\datos\\prueba.txt");
//            PrintWriter toma el archivo definido con FileWriter para comenzar a escribir sobre el, al abrir el archivo se ve lo que se escribio con el for
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
