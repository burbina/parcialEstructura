package parcial;

//NOMBRE: Julián David Acosta Ramirez
//CÓDIGO: 1000252139
import java.util.Scanner;

public class TrabajoWarshall {

    

    private int[][] matrizdistancia; 
    private int[][] matrizdistancia2;
    private int[][] matrizcopia;

    public TrabajoWarshall() {
    }

    public TrabajoWarshall(int[][] matrizdistancia, int[][] matrizdistancia2, int[][] matrizcopia) {
        this.matrizdistancia = matrizdistancia;
        this.matrizdistancia2 = matrizdistancia2;
        this.matrizcopia = matrizcopia;
    }
    
    
    
    public int[][] getMatrizdistancia() {
        return matrizdistancia;
    }

    public void setMatrizdistancia(int[][] matrizdistancia) {
        this.matrizdistancia = matrizdistancia;
    }

    public int[][] getMatrizdistancia2() {
        return matrizdistancia2;
    }

    public void setMatrizdistancia2(int[][] matrizdistancia2) {
        this.matrizdistancia2 = matrizdistancia2;
    }

    public int[][] getMatrizcopia() {
        return matrizcopia;
    }

    public void setMatrizcopia(int[][] matrizcopia) {
        this.matrizcopia = matrizcopia;
    }
    
    
    public void RutaMasCorta() {
        for (int i = 0; i < getMatrizdistancia().length; i++) {
            for (int j = 0; j < getMatrizdistancia().length; j++) {
                for (int k = 0; k < getMatrizdistancia().length; k++) {
                    if ((getMatrizdistancia()[j][i] + getMatrizdistancia()[i][k]) < getMatrizdistancia()[j][k]) {
                        getMatrizdistancia()[j][k] = (getMatrizdistancia()[j][i] + getMatrizdistancia()[i][k]);
                    }
                }
            }
        }
    }

    public void calcularRuta() {
        for (int i = 0; i < getMatrizdistancia2().length; i++) {
            for (int j = 0; j < getMatrizdistancia2().length; j++) {
                if (getMatrizdistancia2()[i][j] == 999) {
                    getMatrizcopia()[i][j] = -1;
                } else {
                    getMatrizcopia()[i][j] = i;
                }
            }
        }

        for (int i = 0; i < getMatrizcopia().length; i++) {
            getMatrizcopia()[i][i] = i;
        }

        for (int i = 0; i < getMatrizdistancia2().length; i++) {
            for (int j = 0; j < getMatrizdistancia2().length; j++) {
                for (int k = 0; k < getMatrizdistancia2().length; k++) {
                    if ((getMatrizdistancia2()[j][i] + getMatrizdistancia2()[i][k]) < getMatrizdistancia2()[j][k]) {
                        getMatrizcopia()[j][k] = getMatrizcopia()[i][k];
                        getMatrizcopia()[0][3] = 1;
                        getMatrizcopia()[3][0] = 1;
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

        for (int i = 0; i < getMatrizcopia().length; i++) {
            for (int j = 0; j < getMatrizcopia().length; j++) {
                System.out.print(getMatrizcopia()[i][j] + " ");
            }
            System.out.println();
        }

        while (getMatrizcopia()[inicio][fin] != inicio) {
            ruta = getMatrizcopia()[inicio][fin] + " -> " + ruta;
            fin = getMatrizcopia()[inicio][fin];
        }

        ruta = inicio + " -> " + ruta;
        System.out.println("La ruta para ir desde el vértice:" + inicio + " Hasta el vértice: " + fin2 + " es: " + ruta);
    }

    public void imprimir() {
        System.out.println("--------------------------------");
        System.out.println("Matriz de Distancias (Modificada)");
        System.out.println();
        for (int i = 0; i < getMatrizdistancia().length; i++) {
            for (int j = 0; j < getMatrizdistancia().length; j++) {
                System.out.print(getMatrizdistancia()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
