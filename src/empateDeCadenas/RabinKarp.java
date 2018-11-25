package empateDeCadenas;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class RabinKarp {
    private String texto;
    private long[] textoHasheado;
    private long[] potencias;
    
    public RabinKarp(String texto) {
        this.texto = texto;
        this.textoHasheado = new long[this.texto.length()+1];
        this.potencias = new long[this.texto.length()];
        calcularPotencias();
        // se computa el texto
        this.textoHasheado = HashingString.calcularHashesPrefijos(this.texto, this.potencias);
    }
    
    private void calcularPotencias() {
        this.potencias[0] = 1;
        for (int i = 1; i < this.texto.length(); i++) {
            this.potencias[i] = 
                (this.potencias[i-1] * HashingString.p) % HashingString.m; 
        }
    }
    
    public ArrayList<Integer> buscarCoincidencias(String s) {
        ArrayList<Integer> ocurrencias = new ArrayList<>();
        long hashPatron = HashingString.calcularHash(s, this.potencias);
        long hashSubstring;
        int ssize = s.length();
        for (int i = 0; i + ssize - 1 < this.texto.length(); i++) {
            hashSubstring = (this.textoHasheado[i+ssize] + HashingString.m - 
                this.textoHasheado[i]) % HashingString.m;
            if(hashSubstring == hashPatron * this.potencias[i] % HashingString.m) {
                ocurrencias.add(i);
            }
        }
        System.out.println("");
        return ocurrencias;
    }
    
    public String getTexto() {
        return this.texto;
    }
    
    public static void main(String []args) {
        String texto = "lasmanzanassonrojas";
        String patron = "as";
        RabinKarp rk = new RabinKarp(texto);
        ArrayList<Integer> ans = rk.buscarCoincidencias(patron);
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
