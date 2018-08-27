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
        Punto[] puntos = new Punto[1000];
        Punto[] puntosLineal = new Punto[1000];
        for (int i = 0; i < 1000; i++) {
            burbuja.sort(GenerarDatos.generarDatosAleatorios(i, 401));
            puntos[i] = new Punto(i, burbuja.getTotalTime());
            puntosLineal[i] = new Punto(i, i/1000);
        }
        
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Burbuja", "n", "tiempo");
        g.agregarSerie("Burbuja", puntos);
        g.agregarSerie("Lineal", puntosLineal);
        g.crearGrafica();
    }
}
