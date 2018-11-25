package tools;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author david
 */
public class Articulo {
    private int beneficio;
    private int peso;
    
    public Articulo() {
        this.beneficio = 1;
        this.peso = 1;
    }
    
    public Articulo(int peso, int beneficio) {
        this.beneficio = beneficio;
        this.peso = peso;
    }
    
    public static Articulo generarArticulo(int capacidadMochila) {
        int beneficio, peso;
        Random ran = new Random();
        beneficio = ran.nextInt(1000) + 1;
        peso = ran.nextInt(capacidadMochila) + 1;
        return new Articulo(beneficio, peso);
    }
    
    public static ArrayList<Articulo> generarArticulos(int capacidadMochila, int n) {
        ArrayList<Articulo> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(generarArticulo(capacidadMochila));
        }
        return A;
    }
    
    public static void imprimirArticulos(ArrayList<Articulo> articulos) {
        for (Articulo articulo : articulos) {
            System.out.println("Peso: " + articulo.peso + " ||| Beneficio: " 
                + articulo.beneficio);
        }
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
  
}
