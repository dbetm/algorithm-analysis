package recursividad;

/**
 *
 * @author david
 */
public class Ejemplos_p1 {
    public static int factorial(int n) {
        if(n == 1) return 1;
        return n * Ejemplos_p1.factorial(n - 1);
    }
    
    public static int sumar(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        return 1 + sumar(a, b - 1);
    }
    
    public static void main(String []args) {
        System.out.println("Factorial de 8: " + Ejemplos_p1.factorial(8));
        System.out.println("La suma de 8 y 15 es: " + Ejemplos_p1.sumar(8, 15));
    }
}
