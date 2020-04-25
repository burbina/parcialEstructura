package estructuras;

//NOMBRE: Julián David Acosta Ramirez
//CÓDIGO: 1000252139
import java.util.Scanner;

public class TrabajoWarshall {

    public int[][] matrizdistancia = {{0, 4, 8, 999, 999}, {4, 0, 1, 2, 999}, {8, 999, 0, 4, 2}, {999, 2, 4, 0, 7}, {999, 999, 2, 7, 0}};
    public int[][] matrizdistancia2 = {{0, 4, 8, 999, 999}, {4, 0, 1, 2, 999}, {8, 999, 0, 4, 2}, {999, 2, 4, 0, 7}, {999, 999, 2, 7, 0}};
    public int[][] matrizcopia = new int[matrizdistancia.length][matrizdistancia.length];

    public static void main(String[] args) {
        // TODO code application logic here
        TrabajoWarshall cl = new TrabajoWarshall();
        cl.RutaMasCorta();
        cl.imprimir();
        cl.calcularRuta();
    }

    public void RutaMasCorta() {
        for (int i = 0; i < matrizdistancia.length; i++) {
            for (int j = 0; j < matrizdistancia.length; j++) {
                for (int k = 0; k < matrizdistancia.length; k++) {
                    if ((matrizdistancia[j][i] + matrizdistancia[i][k]) < matrizdistancia[j][k]) {
                        matrizdistancia[j][k] = (matrizdistancia[j][i] + matrizdistancia[i][k]);
                    }
                }
            }
        }
    }

    public void calcularRuta() {
        for (int i = 0; i < matrizdistancia2.length; i++) {
            for (int j = 0; j < matrizdistancia2.length; j++) {
                if (matrizdistancia2[i][j] == 999) {
                    matrizcopia[i][j] = -1;
                } else {
                    matrizcopia[i][j] = i;
                }
            }
        }

        for (int i = 0; i < matrizcopia.length; i++) {
            matrizcopia[i][i] = i;
        }

        for (int i = 0; i < matrizdistancia2.length; i++) {
            for (int j = 0; j < matrizdistancia2.length; j++) {
                for (int k = 0; k < matrizdistancia2.length; k++) {
                    if ((matrizdistancia2[j][i] + matrizdistancia2[i][k]) < matrizdistancia2[j][k]) {
                        matrizcopia[j][k] = matrizcopia[i][k];
                        matrizcopia[0][3] = 1;
                        matrizcopia[3][0] = 1;
                    }
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Vértice inicial (Entre 0 y 4): ");
        int inicio = scan.nextInt();
        System.out.println("Vértice final (Entre 0 y 4): ");
        int fin = scan.nextInt();
        int fin2 = fin;

        String ruta = fin + "";
        System.out.println("--------------------------------");
        System.out.println("Matriz de Adyacencia");
        System.out.println();

        for (int i = 0; i < matrizcopia.length; i++) {
            for (int j = 0; j < matrizcopia.length; j++) {
                System.out.print(matrizcopia[i][j] + " ");
            }
            System.out.println();
        }

        while (matrizcopia[inicio][fin] != inicio) {
            ruta = matrizcopia[inicio][fin] + " -> " + ruta;
            fin = matrizcopia[inicio][fin];
        }

        ruta = inicio + " -> " + ruta;
        System.out.println("La ruta para ir desde el vértice:" + inicio + " Hasta el vértice: " + fin2 + " es: " + ruta);
    }

    public void imprimir() {
        System.out.println("--------------------------------");
        System.out.println("Matriz de Distancias (Modificada)");
        System.out.println();
        for (int i = 0; i < matrizdistancia.length; i++) {
            for (int j = 0; j < matrizdistancia.length; j++) {
                System.out.print(matrizdistancia[i][j] + " ");
            }
            System.out.println();
        }
    }
}
