/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        // Para poder graficar
        Punto[] puntos = new Punto[10000];
        //Punto[] puntosLineal = new Punto[10000];
        for (int i = 0; i < 10000; i++) {
            insert.sort(GenerarDatos.generarDatosAleatorios(i, 501));
            puntos[i] = new Punto(i, insert.getTotalTime());
            //puntosLineal[i] = new Punto(i, i/1000);
            System.out.println("i: " + i);
        }
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Inserción directa", "n", "tiempo");
        g.agregarSerie("Insert sort", puntos);
        //g.agregarSerie("Lineal", puntosLineal);
        g.crearGrafica();
    }
}
