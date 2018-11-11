package Practicas;

import Programacion_dinamica.FuerzaBrutaMochilaEntera;
import Programacion_dinamica.MochilaDinamica;
import java.util.ArrayList;
import tools.Articulo;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac5_FBruta_vs_PD_MochilaDinamica {
    
    public static void main(String []args) {
        // Se instancian ambos algoritmos
        MochilaDinamica md = new MochilaDinamica();
        FuerzaBrutaMochilaEntera fbmd = new FuerzaBrutaMochilaEntera();

        // ¿Hasta que n se va a probar el algoritmo?
        int n = 20;

        final int capacidadMochila = 500;

        // Coleccción de artículos
        ArrayList<Articulo> articulos;

        // Arreglos de puntos para poder graficar
        Punto[] ptsMochilaDinamica = new Punto[n+1];
        Punto[] ptsFuerzaBruta = new Punto[n+1];
        
        // Para n 0, los pts se setan en 0
        ptsMochilaDinamica[0] = new Punto(0, 0);
        ptsFuerzaBruta[0] = new Punto(0, 0);

        for (int i = 1; i <= n; i++) {
            articulos = Articulo.generarArticulos(capacidadMochila, i);
            // Se ejecuta mochila dinámica con programación dinámica.
            int maxBeneficio1 = md.calcularMayorBeneficio(articulos, capacidadMochila);
            // Se guarda el punto (n, tiempo).
            ptsMochilaDinamica[i] = new Punto(i, md.getTotalTime());
            
            // Se ejecuta mochila entera con fuerza bruta
            int maxBeneficio2 = fbmd.calcularMayorBeneficio(articulos, capacidadMochila);
            // Se guarda el punto (n, tiempo).
            ptsFuerzaBruta[i] = new Punto(i, fbmd.getTotalTime());
            
            System.out.println(maxBeneficio1 == maxBeneficio2);
            System.out.println("Combinación maximizadora: " + 
                md.obtenerCombinacionMaximizadora(capacidadMochila) + " == " + 
                    fbmd.obtenerCombinacionMaximizadora(capacidadMochila) + "\n");
        }
        
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Solución mochila entera: Fuerza bruta vs PD", "n", "tiempo");
        // Se agregan las series de datos (puntos).
        g.agregarSerie("Fuerza bruta", ptsFuerzaBruta);
        g.agregarSerie("Programación dinámica", ptsMochilaDinamica);
        g.crearGrafica();
    }
}
