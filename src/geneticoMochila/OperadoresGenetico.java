package geneticoMochila;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author david
 */
public class OperadoresGenetico {
    
    public static Individuo cruza(Individuo madre, Individuo padre, int capacidad) {
        Individuo hijo1 = generarIndividuoValido(madre, padre, capacidad);
        Individuo hijo2 = generarIndividuoValido(madre, padre, capacidad);
        
        if(hijo1.getFitness() > hijo2.getFitness()) {
            return hijo1;
        }
        else 
            return hijo2;
    }
    
    public static Individuo seleccionAleatoria(ArrayList<Individuo> poblacion, 
            int capacidad) {
        Random ran = new Random();
        int pos;
        do {            
            pos = ran.nextInt(poblacion.size());
        } while (!poblacion.get(pos).esValido(capacidad));
        
        return poblacion.get(pos);
    }
    
    public static void mutar(Individuo ind) {
        Random ran = new Random();
        int pos = ran.nextInt(ind.getGenotipo().length);
        if(ind.getGenotipo()[pos] == 1) ind.getGenotipo()[pos] = 0;
        else ind.getGenotipo()[pos] = 1;
        // refrescamos su fitness
        ind.calcularFitness();
    }
    
    private static Individuo generarIndividuoValido(Individuo madre, Individuo padre,
        int capacidadMochila) {
        Individuo hijo;
        int mask[] = new int[madre.getGenotipo().length];
        int genotipo[] = new int[padre.getGenotipo().length];
        Random ran = new Random();
        
        do {
            for (int i = 0; i < mask.length; i++) {
                mask[i] = ran.nextInt(2);
                if(mask[i] == 1) genotipo[i] = madre.getGenotipo()[i];
                else genotipo[i] = padre.getGenotipo()[i];
            }
            hijo = new Individuo(genotipo);
        } while (!hijo.esValido(capacidadMochila));
        return hijo;
    }
}
