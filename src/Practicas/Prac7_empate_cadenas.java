package Practicas;

import empateDeCadenas.*;
import tools.Grafica;
import tools.Punto;

/**
 *
 * @author david
 */
public class Prac7_empate_cadenas {
    
    public static void main(String args[]) {
        // Se definen las entradas
        String textos[] = new String[7];
         // longitud de 10
        textos[0] = "somoscomom";
         // longitud de 50
        textos[1] = "somoscomomariposasquevuelanduranteundiapensandoque";
        // longitud de 100
        textos[2] = "somoscomomariposasquevuelanduranteundiapensandoqjsbdywbdq"
            + "jdbaxjsfbfbsfbdijwidwjbwdwbfsfjbsjfgadsngat";
        // longitud de 500
        textos[3] = "somoscomomariposasquevuelanduranteundiapensandoqjsbdywbdqj"
            + "dbaxjsfbfbsfbdijwidwjbwdwbfsfjbsjfgadsngatadbahbdloscaracolessonm"
            + "agicosenlatierradeloscaracolesaaadiaplasvacacionesestancercaababa"
            + "bakskskskshshshshsgagagagajsjsjsjsjslslslslsrsrsrrdrororororbsbs"
            + "bsbsjsjsjsjskskskslslslsyellowmagicvivalavidacoldplaymiracleslas"
            + "tiesbabdjbsdjsdjsjsnfhfdsnfjefinstitutopolitecniconacionaluniver"
            + "sidaddeguadalajarauniversidaddeguanajuatouniversidadautonomademex"
            + "icouniversidadnacionalautonomademexicouniversidaddequer";
        // longitud de 10,000
        textos[4] = "somoscomomariposasquevuelanduranteundiapensandoqjsbdywbdqj"
                + "dbaxjsfbfbsfbdijwidwjbwdwbfsfjbsjfgadsngatadbahbdloscaracoles"
                + "sonmagicosenlatierradeloscaracolesaaadiaplasvacacionesestance"
                + "rcaabababakskskskshshshshsgagagagajsjsjsjsjslslslslsrsrsrrdro"
                + "rorororbsbsbsbsjsjsjsjskskskslslslsyellowmagicvivalavidacoldp"
                + "laymiracleslastiesbabdjbsdjsdjsjsnfhfdsnfjefinstitutopolitecn"
                + "iconacionaluniversidaddeguadalajarauniversidaddeguanajuatoun"
                + "iversidadautonomademexicouniversidadnacionalautonomademexicou"
                + "niversidaddequeretaroqwqwqwqwewewreretrtrytytuyuyuiiuiuoioipo"
                + "paasassdsfdfdgfgffghjhjkjklklkzxzxzcxcxvcvcbvbnbnmnmmqmqnwnbr"
                + "bbtbuvuvicioxopzplalksksjdjhfhggftenfeenencaosmetallicaipnipn"
                + "ipnipnipnmexmemxlalalalalalalalalakakakakakakajsjsjsjsjshdhdh"
                + "dhdhdhasasgreedyicpcmexicomexicomexicocualesladiferenciainsti"
                + "tutopoliteniconacionalaashardiapaashardiapaashardiapaashardi"
                + "apaashardiapaashardiapaashardiapvaashardiapaashardiapfaltanno"
                + "vecientosdoscaracterteresnoquierodormirnoquierodormirnoquiero"
                + "dormirminombreesdavidbetancou";
        textos[4] += textos[4]; // 2000
        textos[4] = textos[4] + textos[4] + textos[4] + textos[4] + textos[4];
        // longitud de 50,000
        textos[5] = textos[4] + textos[4] + textos[4] + textos[4] + textos[4];
        // longitud de 100,000
        textos[6] = textos[5] + textos[5];
        // Patrones a buscar
        String patrones[] = new String[]{"a", "as", "har", "diap"};
        // Los tamaños de las entradas que necesitamos para graficar
        int entradas[] = new int[]{10, 50, 100, 500, 10000, 50000, 100000};
        
        // Se declaran ambos algoritmos
        RabinKarp rk;
        FuerzaBruta fb;
        // Puntos para graficar
        Punto puntosRabinKarp[] = new Punto[7];
        Punto puntosFuerzaBruta[] = new Punto[7];
        
        // Variables para acumular los tiempos
        long tRK;
        long tFB;
        
        for (int i = 0; i < 7; i++) {
            // Tiempos en cero
            tRK = 0;
            tFB = 0;
            // se instancian los algoritmos y se buscan las ocurrencias de 
            // todos los patrones
            
            // ## Rabin-Karp
            rk = new RabinKarp(textos[i]);
            // ## Fuerza bruta
            fb = new FuerzaBruta(textos[i]);
            for (int j = 0; j < 4; j++) {
                rk.buscarCoincidencias(patrones[j]);
                tRK += rk.getTotalTime();
                
                fb.buscarCoincidencias(patrones[j]);
                tFB += fb.getTotalTime();
            }
            // Agregamos los puntos
            puntosRabinKarp[i] = new Punto(entradas[i], tRK);
            puntosFuerzaBruta[i] = new Punto(entradas[i], tFB);
        }
        
        // Se instancia una nueva gráfica
        Grafica g = new Grafica("Rabin Karp vs Fuerza bruta", "n", "tiempo");
        // Se agregan las series de datos (puntos).
        g.agregarSerie("Rabin-Karp", puntosRabinKarp);
        g.agregarSerie("Fuerza bruta", puntosFuerzaBruta);
        g.crearGrafica();
    }
}
