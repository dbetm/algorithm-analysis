package Practicas;

import ordenamiento.Bubble;
import ordenamiento.InsertSort;
import ordenamiento.OptBubble;
import tools.GenerarDatos;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac1_bubble_insert_optB {
    
    public static void main(String[] args) {
        InsertSort insert = new InsertSort();
        Bubble bubble = new Bubble();
        OptBubble optBubble = new OptBubble();
        
        double[] datos;
        
        Punto[] puntosBubble = new Punto[10001];
        Punto[] puntosInsert = new Punto[10001];
        Punto[] puntosOptBubble = new Punto[10001];
        
        for (int i = 0; i < 10001; i++) {
            // Para que tengan la misma entrada
                // Caso medio
            //datos = GenerarDatos.generarDatosAleatorios(i, 501);
                // Mejor caso
            //datos = GenerarDatos.generarDatosMejorCaso(i);
                // Peor caso
            datos = GenerarDatos.generarDatosPeorCaso(i);
            
            // Se ordenan, y se guarda el punto (n, tiempo).
            bubble.sort(datos.clone());
            puntosBubble[i] = new Punto(i, bubble.getTotalTime());
            
            insert.sort(datos.clone());
            puntosInsert[i] = new Punto(i, insert.getTotalTime());
            
            optBubble.sort(datos.clone());
            puntosOptBubble[i] = new Punto(i, optBubble.getTotalTime());
            
            System.out.println(i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Inserción vs Burbuja vs Burbuja optimizado", "n", "tiempo");
        // Se agregan las series de datos (puntos).
        g.agregarSerie("Bubble", puntosBubble);
        g.agregarSerie("Insert sort", puntosInsert);
        g.agregarSerie("Burbuja optimizado", puntosOptBubble);
        g.crearGrafica();
    }
}
