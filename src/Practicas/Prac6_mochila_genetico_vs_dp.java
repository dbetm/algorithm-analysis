package Practicas;

import Programacion_dinamica.MochilaDinamica;
import geneticoMochila.Genetico;
import geneticoMochila.Individuo;
import java.util.ArrayList;
import tools.Articulo;
import tools.Tokenizador;

/**
 *
 * @author david
 */
public class Prac6_mochila_genetico_vs_dp {
    
    public static void main(String []args) {
        // Se obtienen los artículos
        Tokenizador.leerDatos();
        // Se cargan en los artículos que necesita el genético
        Genetico.articulos = (ArrayList<Articulo>) Tokenizador.articulos.clone();
        int capacidades[] = new int[]{10000, 9940, 9000, 8995};
        // Se instancia una sola vez el algoritmo que implementa DP
        MochilaDinamica md = new MochilaDinamica();
        for (int i = 0; i < capacidades.length; i++) {
            System.out.println("Capacidad: " + capacidades[i]);
            // Cada vez se instancia el algoritmo genético
            Genetico g = new Genetico(100, 50, 10000, 0.5, capacidades[i]);
            Individuo maxBeneficioGen = g.evolucionar();
            // Se manda llamar el método para recuperar el máximo beneficio
            System.out.println("Genético: " + maxBeneficioGen.getFitness());
            // El de la mochila no es necesario volver a instanciarlo
            int maxBeneficioDP = 
                md.calcularMayorBeneficio(Tokenizador.articulos, capacidades[i]);
            System.out.println("Programación dinámica: " + maxBeneficioDP + "\n");
            
            // Imprimir la lista de artículos seleccionados
            //sSystem.out.println("" + maxBeneficioGen.getGenotipo().toString());
            imprimirGenotipo(maxBeneficioGen.getGenotipo());
        }
    }
    
    public static void imprimirGenotipo(int[] genotipo) {
        for (int i = 0; i < genotipo.length; i++) {
            System.out.print(genotipo[i]);
        }
        System.out.println("\n");
    }
    
}
