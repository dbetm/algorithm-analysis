/*  
  Los algoritmos genéticos se inspiran en la evolución natural para solucionar 
  problemas de optimización que de otra forma serían difíciles para un diseñador 
  humano. En vez de una población de gacelas, tienes un conjunto de soluciones al 
  problema a resolver. Se llama población al conjunto de soluciones e individuo a 
  cada una de las soluciones (aunque la terminología puede variar según quién te 
  lo explique). El algoritmo evalúa cada una de las soluciones y selecciona las 
  que mejor resuelven el problema.
*/
package geneticoMochila;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Genetico {
    // ## Atributos ##
    public static ArrayList<Articulo> articulos;
    private int numArticulos; // el número de items pos cada individuo
    private int tamPoblacion; // número de individuos
    private int numGeneraciones;
    private double probabilidadMutacion;
    private ArrayList<Individuo> poblacionActual;
    
    // ## Constructor ##
    public Genetico(int numArt, int tamPoblacion, int numGeneraciones, double probMuta) {
        this.numArticulos = numArt;
        this.tamPoblacion = tamPoblacion;
        this.numGeneraciones = numGeneraciones;
        this.probabilidadMutacion = probMuta;
        this.poblacionActual = new ArrayList<>();
    }
    
    public void evolucionar() {
        // Generar una población aleatoria
        for (int i = 0; i < this.tamPoblacion; i++) {
            Individuo aux = new Individuo(this.numArticulos);
            aux.calcularFitness();
            this.poblacionActual.add(aux);
        }
        
        // Se genera un proceso evolutivo
        for (int g = 0; g < this.numGeneraciones; g++) {
            // Construir una población nueva
            double mejor = -1;
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            // se genera cada individuo de la nueva población
            for (int i = 0; i < this.tamPoblacion; i++) {
                Individuo madre = OperadoresGenetico.seleccionAleatoria(this.poblacionActual);
                Individuo padre = OperadoresGenetico.seleccionAleatoria(this.poblacionActual);
                Individuo hijo = OperadoresGenetico.cruza(madre, padre);
                if(this.probabilidadMutacion >= Math.random()) {
                    OperadoresGenetico.mutar(hijo);
                }
                // Se verifica si se ha encontrado una mejor solución
                if(hijo.getFitness() > mejor) mejor = hijo.getFitness();
                nuevaPoblacion.add(hijo);
            }
            System.out.println("El mejor es: " + mejor);
            // Actualizamos la generación actual
            this.poblacionActual.clear();
            this.poblacionActual = (ArrayList<Individuo>) nuevaPoblacion.clone();
        }
    }
}
