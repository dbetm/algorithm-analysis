package Tests;

import ordenamiento.Bubble;
import ordenamiento.InsertSort;
import tools.GenerarDatos;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class InsertVsBubble {
    public static void main(String[] args) {
        InsertSort insert = new InsertSort();
        Bubble bubble = new Bubble();
        double[] datos;
        
        Punto[] puntosBubble = new Punto[10000];
        Punto[] puntosInsert = new Punto[10000];
        for (int i = 0; i < 10000; i++) {
            // Para que tengan la misma entrada
            datos = GenerarDatos.generarDatosAleatorios(i, 501);
            // Se ordenan
            insert.sort(datos);
            bubble.sort(datos);
            puntosBubble[i] = new Punto(i, bubble.getTotalTime());
            puntosInsert[i] = new Punto(i, insert.getTotalTime());
            System.out.println("i: " + i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Inserción directa vs Burbuja", "n", "tiempo");
        g.agregarSerie("Bubble", puntosBubble);
        g.agregarSerie("Insert sort", puntosInsert);
        g.crearGrafica();
    }
}
