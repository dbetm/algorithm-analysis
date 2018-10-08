package tools;

import java.util.Random;

/**
 *
 * @author david
 */
public class GenCharArray {
    public static Random ran = new Random();
    
    // Genera un arreglo de carácteres de tamaño n, insertando c al azar.
    public static char[] generarArregloCasoMedio(int n, char c) {
        char[] ans = new char[n];
        
        for (int i = 0; i < n; i++) ans[i] = (char)(ran.nextInt(90) + 36);
        // Inserta c al azar
        System.out.println(n);
        int pos = ran.nextInt(n);
        ans[pos] = c;
        
        return ans;
    }
    
    // Genera un arreglo de carácteres de tamaño n, insertando c al inicio
    public static char[] generarArregloMejorCaso(int n, char c) {
        char[] ans = new char[n];
        // Se agrega el carácter c al inicio
        ans[0] = c;
        for (int i = 1; i < n; i++) ans[i] = (char)(ran.nextInt(90) + 36);
        
        return ans;
    }
    
    public static char[] generarArregloPeorCaso(int n, char c) {
        char[] ans = new char[n];
        // Se agrega el carácter c al final
        ans[n - 1] = c;
        for (int i = 0; i < n - 1; i++) ans[i] = (char)(ran.nextInt(90) + 36);
        
        return ans;
    }
    
    private static void display(char[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }
    
    // Pueba unitaria
    public static void main(String []args) {
        char[] data;
        data = generarArregloCasoMedio(8, '#');
        display(data);
        data = generarArregloMejorCaso(8, '#');
        display(data);
        data = generarArregloPeorCaso(8, '#');
        display(data);
    }

    
}
