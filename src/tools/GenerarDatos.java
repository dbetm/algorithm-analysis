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
}
