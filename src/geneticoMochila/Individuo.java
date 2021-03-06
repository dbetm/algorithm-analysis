package geneticoMochila;
// Un individuo representan varios artículos, siendo así una tenativa de solución

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author david
 */
public class Individuo {
    // ### Atributos ###
    // Se denomina el material genético de un individuo
    private int[] genotipo;
    /* Se le llama fenotipo (características del individuo producidas por
    los genes, el fitness es una de esas características que emergen de su genotipo*/
    
    // Bondad, como la suma de los beneficios que aporta el conjunto de artículos.
    private int fitness;
    
    // ### Constructores ###
    public Individuo(int numGenes) {
        this.genotipo = new int[numGenes];
        this.fitness = 0;
        generarBytesAleatorios();
    }
    
    public Individuo(Individuo ind) {
        this.genotipo = ind.getGenotipo().clone();
        this.fitness = ind.getFitness();
    }
    
    public Individuo(int[] genotipo) {
        this.genotipo = genotipo.clone();
        calcularFitness();
    }
    
    // ## Métodos ###
    private void generarBytesAleatorios() {
        /* completamos (pseudoaleatoriamente) el vector que representa los genes 
        del individuo */
        Random r = new Random();
        for (int i = 0; i < this.genotipo.length; i++) {
            this.genotipo[i] = r.nextInt(2);
        }
    }
    
    public void calcularFitness() {
        this.fitness = 0;
        // Recorre el genotipo para obtener su fitness
        for (int i = 0; i < this.genotipo.length; i++) {
            if(this.genotipo[i] == 1) 
                this.fitness += Genetico.articulos.get(i).getBeneficio();
        }
    }
    
    public boolean esValido(int capacidad) {
        /* Para saber si un individuo es válido, esto es, no debe exceder el
        peso máximo permitido de la mochila */
        int acumulado = 0;
        boolean ans = true;
        // Se recorre el genotipo
        for (int i = 0; i < this.genotipo.length; i++) {
            if(this.genotipo[i] == 1) {
                acumulado += Genetico.articulos.get(i).getPeso();
                if(acumulado > capacidad) {
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
    
    //  ### Métodos de acceso ###
    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Su genotipo es: " + Arrays.toString(this.genotipo);
        aux += "  -- Su fitness es: " + this.fitness;
        //  Obtener peso
        int peso = 0;
        for (int i = 0; i < this.genotipo.length; i++) {
            if(this.genotipo[i] == 1) peso += Genetico.articulos.get(i).getPeso();
        }
        aux += "-- Su peso es: " + peso;
        return aux;
    }  
}
