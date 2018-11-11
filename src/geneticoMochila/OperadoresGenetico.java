package geneticoMochila;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author david
 */
public class OperadoresGenetico {
    public static Individuo cruza(Individuo madre, Individuo padre) {
        int mask[] = new int[]{1, 1, 1, 0, 0, 0}; // por mientras
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        Individuo hijo1, hijo2;
        
        for (int i = 0; i < mask.length; i++) {
            if(mask[i] == 1) {
                genotipo1[i] = madre.getGenotipo()[i];
                genotipo2[i] = padre.getGenotipo()[i];
            }
            else {
                genotipo1[i] = padre.getGenotipo()[i];
                genotipo2[i] = madre.getGenotipo()[i];
            }
        }
        hijo1 = new Individuo(genotipo1);
        hijo2 = new Individuo(genotipo2);
        // se selecciona el de mayor bondad
        if(hijo1.getFitness() > hijo2.getFitness()) {
            return hijo1;
        }
        return hijo2;
    }
    
    public static Individuo seleccionAleatoria(ArrayList<Individuo> poblacion) {
        Random ran = new Random();
        int pos = ran.nextInt(poblacion.size());
        return poblacion.get(pos);
    }
    
    public static void mutar(Individuo ind) {
        Random ran = new Random();
        int pos = ran.nextInt(ind.getGenotipo().length);
        if(ind.getGenotipo()[pos] == 1) {
            ind.getGenotipo()[pos] = 0;
        }
        else {
            ind.getGenotipo()[pos] = 1;
        }
        // refrescamos su fitness
        ind.calcularFitness();
    }
}
