package Practicas;

import busqueda.Binaria;
import busqueda.Lineal;
import tools.GenCharArray;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac4_search {
    public static void main(String []args) {
        int pos1, pos2;
        // Se realizan las instancias de los algoritmos
        Binaria b = new Binaria();
        Lineal l = new Lineal();
        
        // ¿Hasta que n se va a probar el algoritmo?
        int n = 200000;
        // Carácter a buscar
        char c = '#';
        
        // Arreglo para guardar los datos, que serán la entrada de los
        // algoritmos
        char[] datos;
        
        // Arreglos de puntos para poder graficar
        Punto[] puntosBinaria = new Punto[n];
        Punto[] puntosLineal = new Punto[n];
        
        for (int i = 1; i <= n; i++) {
            // Para que tengan la misma entrada:
                // Caso medio
            //datos = GenCharArray.generarArregloCasoMedio(i, c);
                // Mejor caso
            //datos = GenCharArray.generarArregloMejorCaso(i, c);
                // Peor caso
            datos = GenCharArray.generarArregloPeorCaso(i, c);
            
            // Se busca, y se guarda el punto (n, tiempo).
            pos1 = b.buscar(datos.clone(), c);
            puntosBinaria[i-1] = new Punto(i, b.getTotalTime());
            
            pos2 = l.buscar(datos.clone(), c);
            puntosLineal[i-1] = new Punto(i, l.getTotalTime());
            
            //System.out.println(i + " >> " + pos1 + " = " + pos2);
            System.out.println(i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Mejor caso: Búsqueda lineal vs búsqueda binaria", "n", "tiempo");
        // Se agregan las series de datos (puntos).
        g.agregarSerie("Lineal o secuencial", puntosLineal);
        g.agregarSerie("Binaria", puntosBinaria);
        g.crearGrafica();
    }
}
