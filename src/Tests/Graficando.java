package Tests;

import java.util.Random;
import tools.Grafica;
import tools.Punto;

 /* @author david */
public class Graficando {
    
    public static void main(String[] args) {
        // Se declaran dos arreglos de puntos, de tamaño 100 cada una
        Punto[] puntos1 = new Punto[100];
        Punto[] puntos2 = new Punto[100];
    
        Random ran = new Random();
        /* Se agregan 100 puntos (objetos), generando sus parámetros 
        pseudoaleatoriamente */
        for (int i = 0; i < 100; i++) {
            puntos1[i] = new Punto(ran.nextInt(100), ran.nextInt(100));
            puntos2[i] = new Punto(ran.nextInt(100), ran.nextInt(100));
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Ejemplo", "n", "tiempo");
        g.agregarSerie("Serie1", puntos1);
        g.agregarSerie("Serie2", puntos2);
        g.crearGrafica();
    }    
}
