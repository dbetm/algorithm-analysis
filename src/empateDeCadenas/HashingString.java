package empateDeCadenas;

/**
 *
 * @author david
 */
public class HashingString {
    // entero primo recomendando para cadenas con carácteres del alfabeto en minúscula
    public static final int p = 31;
    // m es un primo considerado grande, ya que es el primo más grande que 
    // cabe en un entero positivo sin signo en C/C++.
    public static final long m = (long) (1e9 + 9);
    
    // Básicamente hace una suma: 
    // hash(s) = {s[0] + s[1]*p^1 + s[2]*p^2+...+s[n-1]*p^(n-1)} % mod m
    public static long calcularHash(String s) {
        long hash = 0;
        long p_pow = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash = (hash + (c - 'a' + 1) * p_pow) % m;
            p_pow = (long) (Math.pow(p, i)) % m;
        }
        return hash;
    }
    
    public static long calcularHash(String s, long[] potencias) {
        long hash = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash = (hash + (c - 'a' + 1) * potencias[i]) % m;
        }
        return hash;
    }
    
    public static long[] calcularHashesPrefijos(String texto, long[] potencias) {
        long ans[] = new long[texto.length()+1];
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            ans[i+1] = (ans[i] + (c - 'a' + 1) * potencias[i]) % HashingString.m;
        }
        return ans;
    }
}
