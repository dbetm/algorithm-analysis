package Practicas;

import ordenamiento.Bubble;
import ordenamiento.InsertSort;
import ordenamiento.Merge;
import ordenamiento.OptBubble;
import ordenamiento.QuickSort;
import tools.GenerarDatos;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac3_quickSort {
    public static void main(String args[]) {
        // Se realizan las instancias de los algoritmos
        Merge merge = new Merge();
        InsertSort insert = new InsertSort();
        Bubble bubble = new Bubble();
        OptBubble optBubble = new OptBubble();
        QuickSort qs = new QuickSort();
        
        // ¿Hasta que n se va a probar el algoritmo?
        int n = 10000;
        
        // Arreglo para guardar los valores generados aleatoriamente
        double[] datos;
        // Arreglos de puntos para poder graficar
        Punto[] puntosMerge = new Punto[n];
        Punto[] puntosBubble = new Punto[n];
        Punto[] puntosInsert = new Punto[n];
        Punto[] puntosOptBubble = new Punto[n];
        Punto[] puntosQuickSort = new Punto[n];
        
        for (int i = 0; i < n; i++) {
            // Para que tengan la misma entrada:
                // Caso medio
            //datos = GenerarDatos.generarDatosAleatorios(i, 501);
                // Mejor caso
            //datos = GenerarDatos.generarDatosMejorCaso(i);
                // Peor caso
            datos = GenerarDatos.generarDatosPeorCaso(i);
            
            // Se ordenan, y se guarda el punto (n, tiempo).
       
            merge.sort(datos.clone());
            puntosMerge[i] = new Punto(i, merge.getTotalTime());
            
            bubble.sort(datos.clone());
            puntosBubble[i] = new Punto(i, bubble.getTotalTime());
            
            insert.sort(datos.clone());
            puntosInsert[i] = new Punto(i, insert.getTotalTime());
            
            optBubble.sort(datos.clone());
            puntosOptBubble[i] = new Punto(i, optBubble.getTotalTime());
    
            qs.sort(datos.clone());
            
            puntosQuickSort[i] = new Punto(i, qs.getTotalTime());
            
            System.out.println(i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Inserción vs Burbuja vs Burbuja optimizado vs "
            + "Merge sort vs Quick Sort", "n", "tiempo");
        // Se agregan las series de datos (puntos).
        g.agregarSerie("Merge sort", puntosMerge);
        g.agregarSerie("Bubble", puntosBubble);
        g.agregarSerie("Insert sort", puntosInsert);
        g.agregarSerie("Burbuja optimizado", puntosOptBubble);
        g.agregarSerie("Quick sort", puntosQuickSort);
        g.crearGrafica();

    }
}
