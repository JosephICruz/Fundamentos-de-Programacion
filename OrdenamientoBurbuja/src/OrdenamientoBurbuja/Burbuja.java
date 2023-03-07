/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OrdenamientoBurbuja;

import java.util.Arrays;

/**
 *
 * @author joseph
 */
public class Burbuja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        int[] arreglo = new int[10];  // 0 1 2 3 4 5 6 7 8 9 
       
        arreglo[5]= 7; 
        arreglo[4]= 56;
        arreglo[6]= 89;
        arreglo[3]= 34;
        arreglo[7]= 1234;
        arreglo[2]= -65;
        arreglo[8]= 0;
        arreglo[1]= 678;
        arreglo[9]= 90;
        arreglo[0]= 45678;
        
        System.out.println("Antes del método de la burbuja: " + Arrays.toString(arreglo));
        burbuja(arreglo);
        System.out.println("Después del método de la burbuja: " + Arrays.toString(arreglo));
        
        System.out.println("-------------------------------------------");
       
        String[] arregloTexto = new String[10];  
       
        arregloTexto[5]= "yoli"; 
        arregloTexto[4]= "jeninfer";
        arregloTexto[6]= "leoncio";
        arregloTexto[3]= "omar";
        arregloTexto[7]= "landeo";
        arregloTexto[2]= "galecio";
        arregloTexto[8]= "jesus";
        arregloTexto[1]= "rosalin";
        arregloTexto[9]= "joseph";
        arregloTexto[0]= "luis";
        
        
        System.out.println("Antes del método de la burbuja: " + Arrays.toString(arregloTexto));
        burbuja(arregloTexto);
        System.out.println("Después del método de la burbuja: " + Arrays.toString(arregloTexto));

    
    }
     // funcion de ordenamiento de burbuja de entero
    private static void burbuja(int[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
            for (int y = 0; y < arreglo.length - 1; y++) {
                int elementoActual = arreglo[y];
                int  elementoSiguiente = arreglo[y + 1];
                if (elementoActual > elementoSiguiente) {
                    // Intercambiar
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }
    }

 // funcion de ordenamiento de burbuja de String
    private static void burbuja(String[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
          
            for (int y = 0; y < arreglo.length - 1; y++) {
                String elementoActual = arreglo[y],
                        elementoSiguiente = arreglo[y + 1];
                if (elementoActual.compareTo(elementoSiguiente) > 0) {
                    // Intercambiar
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }
    }
    
    
}
