package tools;

import java.util.ArrayList;
import ordenamiento.SortAlgorithm;

/**
 *
 * @author david
 */
public class Comparador {
    private int cantidadComparaciones;
    private Grafica grafica;

    public Comparador(int cantidadComparaciones) {
        this.cantidadComparaciones = cantidadComparaciones;
        this.grafica = new Grafica("Comparación ordenamiento", 
            "n", "Tiempo ms");
    }
    
    public void comparar(ArrayList<SortAlgorithm> algoritmos) {
        ArrayList<Punto[]> coleccionPuntos = new ArrayList<>();
        
        for (int c = 0; c < cantidadComparaciones; c++) {
            // Ejecución de todos los algoritmos
            double[] data = GenerarDatos.generarDatosAleatorios(c, 501);
            Punto[] puntos = new Punto[cantidadComparaciones];
            for (SortAlgorithm alg : algoritmos) {
                alg.sort(data.clone());
                puntos[c] = new Punto(c, alg.getTotalTime());
            }
        }
    }
    
}
