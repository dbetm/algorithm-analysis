package tools;

import java.util.Random;

/* @author david */
public class GenerarDatos {
    
    public static Random ran = new Random();
    
    public static double[] generarDatosAleatorios(int dim, int limite) {
        double datos[] = new double[dim];
        for (int i = 0; i < dim; i++) {
            datos[i] = ran.nextInt(limite);
        }   
        return datos;
    }
    
    public static double[] generarDatosMejorCaso(int dim) {
        double datos[] = new double[dim];
        for (int i = 0; i < dim; i++) {
            datos[i] = i;
        }   
        return datos;
    }
    
    public static double[] generarDatosPeorCaso(int dim) {
        double datos[] = new double[dim];
        int j = 0;
        for (int i = dim-1; i >= 0; i--) {
            datos[j] = i;
            j++;
        }
        return datos;
    }
    
    // Test
    public static void main(String[] args) {
        generarDatosPeorCaso(10001);
    }
}
