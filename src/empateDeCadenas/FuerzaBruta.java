package empateDeCadenas;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class FuerzaBruta {
    private String texto;
    // para medir los tiempos de completitud al buscar las ocurrencias de cierto patron
    private long initTime;
    private long endTime;
    private long totalTime;
    
    public FuerzaBruta(String texto) {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
        // ---------------
        this.texto = texto;
    }
    
    public ArrayList<Integer> buscarCoincidencias(String s) {
        ArrayList<Integer> ocurrencias = new ArrayList<>();
        
        this.initTime = System.currentTimeMillis();
        
        int ssize = s.length();
        for (int i = 0; i + ssize-1 < this.texto.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < ssize; j++) {
                if(this.texto.charAt(i+j) != s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) ocurrencias.add(i);
        }
        
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        
        return ocurrencias;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public long getTotalTime() {
        return totalTime;
    }
    
    public static void main(String []args) {
        String texto = "lasmanzanassonrojas";
        String patron = "as";
        FuerzaBruta fb = new FuerzaBruta(texto);
        ArrayList<Integer> ans = fb.buscarCoincidencias(patron);
        System.out.println("Número de ocurrencias: " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < texto.length(); j++) {
                if(ans.get(i) == j) System.out.print("[");
                System.out.print(texto.charAt(j));
                if((ans.get(i) + patron.length() - 1) == j) {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }
    }
}
