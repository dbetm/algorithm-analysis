package Practicas;

import avidos.CaballoAjedrez;
import tools.Coordenada;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac8_caballoAjedrez {
    public static void main(String args[]) {
        // Se declara el algoritmo
        CaballoAjedrez caballo;

        // Buscando un patrón para los casos en los que no funciona nuestro algoritmo
        Punto puntos[] = new Punto[101];
        puntos[0] = new Punto(0, 0);
        for (int i = 1; i <= 100; i++) {
            caballo = new CaballoAjedrez(i);
            int n = i;
            int noSol = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!caballo.esSolucion(new Coordenada(j, k))) noSol++;
                }
            }
            System.out.println(i + "," + noSol);
            //puntos[i] = new Punto(i, noSol);
        }
        // Se instancia una nueva gráfica
        //Grafica g = new Grafica("Problema caballo de ajedrez", "n", "No soluciones");
        // Se agregan las series de datos (puntos).
        //g.agregarSerie("Datos", puntos);
        //g.crearGrafica();
    }
}
