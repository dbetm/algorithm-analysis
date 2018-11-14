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
    private int capacidad;
    
    // ## Constructor ##
    public Genetico(int numArt, int tamPoblacion, int numGeneraciones, double probMuta, int capacidad) {
        this.numArticulos = numArt;
        this.tamPoblacion = tamPoblacion;
        this.numGeneraciones = numGeneraciones;
        this.probabilidadMutacion = probMuta;
        this.poblacionActual = new ArrayList<>();
        this.capacidad = capacidad;
    }
    
    public void evolucionar() {
        // Generar una población aleatoria
        for (int i = 0; i < this.tamPoblacion; i++) {
            Individuo aux = new Individuo(this.numArticulos);
            if(!aux.esValido(capacidad)) {
                i--;
                continue;
            }
            aux.calcularFitness();
            this.poblacionActual.add(aux);
        }
        
        // Se genera un proceso evolutivo
        for (int g = 0; g < this.numGeneraciones; g++) {
            // Construir una población nueva
            Individuo mejor = this.poblacionActual.get(0);
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            // se genera cada individuo de la nueva población
            for (int i = 0; i < this.tamPoblacion; i++) {
                Individuo madre = 
                    OperadoresGenetico.seleccionAleatoria(this.poblacionActual, capacidad);
                Individuo padre = 
                    OperadoresGenetico.seleccionAleatoria(this.poblacionActual, capacidad);
                Individuo hijo = 
                    OperadoresGenetico.cruza(madre, padre, this.capacidad);
                if(this.probabilidadMutacion >= Math.random()) {
                    OperadoresGenetico.mutar(hijo);
                    if(!hijo.esValido(capacidad)) {
                        i--;
                        continue;
                    }
                }
                // Se verifica si se ha encontrado una mejor solución
                if(hijo.getFitness() > mejor.getFitness()) mejor = hijo;
                nuevaPoblacion.add(hijo);
            }
            System.out.println("El mejor es: " + mejor.toString());
            // Actualizamos la generación actual
            this.poblacionActual.clear();
            this.poblacionActual = (ArrayList<Individuo>) nuevaPoblacion.clone();
        }
    }
    
    public static void main(String []args) {
        Genetico.articulos = new ArrayList<>();
        Genetico.articulos.add(new Articulo(15, 34));
        Genetico.articulos.add(new Articulo(4, 20));
        Genetico.articulos.add(new Articulo(3, 100));
        Genetico.articulos.add(new Articulo(56, 780));
        Genetico.articulos.add(new Articulo(23, 60));
        Genetico.articulos.add(new Articulo(4, 50));
        
        Genetico gen = new Genetico(6, 50, 100000, 0.4, 80);
        gen.evolucionar();
    }
}
