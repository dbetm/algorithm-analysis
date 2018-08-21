package Tests;

import ordenamiento.Bubble;
import tools.GenerarDatos;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class testBubble {
    public static void main(String[] args) {
        Bubble burbuja = new Bubble();
        // Para poder graficar
        Punto[] puntos = new Punto[10000];
        for (int i = 0; i < 10000; i++) {
            burbuja.sort(GenerarDatos.generarDatosAleatorios(i, 501));
            puntos[i] = new Punto(i, burbuja.getTotalTime());
            System.out.println("i: " + i);
        }
        
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Burbuja", "n", "tiempo");
        g.agregarSerie("Serie1", puntos);
        g.crearGrafica();
    }
    
    
}
