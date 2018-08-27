package Tests;

import ordenamiento.InsertSort;
import tools.GenerarDatos;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class testInsertSort {
    public static void main(String[] args) {
        InsertSort insert = new InsertSort();
        Punto[] puntos = new Punto[10000];
        
        for (int i = 0; i < 10000; i++) {
            // Se ordenan
            insert.sort(GenerarDatos.generarDatosAleatorios(i, 501));
            puntos[i] = new Punto(i, insert.getTotalTime());
            System.out.println("i: " + i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Inserción directa", "n", "tiempo");
        g.agregarSerie("Insert sort", puntos);
        g.crearGrafica();
    }
}
