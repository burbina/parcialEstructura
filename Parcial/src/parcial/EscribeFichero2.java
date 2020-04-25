package estructuras;

/*
Nombre: Julián David Acosta Ramirez.
Código: 1000252139.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*

El siguiente código permite la creación de un fichero.txt, gracias a la clase
File que, como ya sabemos, en caso de que en la ruta especificada no se 
encuentre el archivo.txt es decir, no exista, la clase lo crea en dicha ruta.


Con la clase BufferedWriter, accede al fichero y escribe el resultado de la 
operación en él, ya sea: "El fichero de texto ya estaba creado" o "Acabo de crear
el fichero de texto".


Realizando las pruebas correspondientes: En caso de que el fichero indicado
en la ruta correspondiente exista y tenga datos almacenados en él, el código va a 
borrar su contenido para posteriormente escribir una de las dos sentencias que
están en el método write de la clase BufferedWriter.
*/

public class EscribeFichero2 {
    
        public static void main(String[] args) throws IOException {
        String ruta = "C:\\datos\\archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto");
        }
        bw.close();
    }
        
}