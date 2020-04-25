//Brayan Urbina
//1013678727
package parcial;

import java.io.BufferedReader;
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
        File archivo = null;
        FileReader ficheroEntrada = null;
        FileWriter fichero = null;
        PrintWriter pw=null;
        BufferedReader br = null;
        try {
            fichero = new FileWriter("C:\\1eval\\salida.txt");
     
            pw = new PrintWriter(fichero);
            archivo = new File("C:\\1eval\\entrada.txt");
            ficheroEntrada = new FileReader(archivo);
            br = new BufferedReader(ficheroEntrada);
            
            String linea;
            int[][] matrizdistancia = new int[6][6];
            int[][] matrizdistancia2 = new int[6][6];
            int contador=0;
            pw.println("--------------Matriz entrada----------------");
            while((linea = br.readLine()) != null) {
                String[] values = linea.split(" ");
                for (int i = 0; i<values.length; i++) {
                matrizdistancia[contador][i] = Integer.parseInt(values[i]);
                matrizdistancia2[contador][i] = Integer.parseInt(values[i]);
                pw.print(values[i]+" ");
                
            }
                contador++;
                pw.print("\n");
            }
            
            TrabajoWarshall cl = new TrabajoWarshall(matrizdistancia,matrizdistancia2,new int[matrizdistancia.length][matrizdistancia.length]);
            cl.calcularRuta();
            pw.println("--------------Matriz SALIDA----------------");            
            for (int i = 0; i < cl.getMatrizcopia().length; i++) {
                for (int j = 0; j < cl.getMatrizcopia().length; j++) {
                    pw.print(cl.getMatrizcopia()[i][j] + " ");
            }
            pw.print("\n");
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
