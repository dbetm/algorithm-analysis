package Programacion_dinamica;

import java.util.ArrayList;
import tools.Articulo;

/**
 *
 * @author david
 */
public class MochilaDinamica {
    private long initTime;
    private long endTime;
    private long totalTime;
    private ArrayList<Articulo> articulos;
    private int[][] matrizBeneficios;
    private int _W; // capacidad máxima de la mochila
    
    public MochilaDinamica() {
        this.articulos = new ArrayList<>();
        this._W = 0;
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
        this.matrizBeneficios = null;
    }
    
    public int calcularMayorBeneficio(ArrayList<Articulo> articulos, int _W) {
        this.articulos = articulos;
        this._W = _W;
        this.initTime = System.currentTimeMillis();
        
        construirMatrizBeneficios();
        calcularMatrizBeneficios();
        
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        return consultarMaximoBeneficio(_W);
    } 

    private void construirMatrizBeneficios() {
        // Inicializamos la matriz
        this.matrizBeneficios = new int[this.articulos.size() + 1][this._W + 1];
        // Llenamos la primer fila con ceros
        for (int j = 0; j < this.matrizBeneficios[0].length; j++) {
            this.matrizBeneficios[0][j] = 0;
        }
        // Llenamos la primer columna con ceros
        for (int i = 1; i <= this.articulos.size(); i++) {
            this.matrizBeneficios[i][0] = 0;
        }
    }

    private void calcularMatrizBeneficios() {
        // Se calcula cada posición de la matriz
        for (int i = 1; i <= this.articulos.size(); i++) {
            for (int w = 1; w <= this._W; w++) {
                /* Se comprueba si el artículo es parte de la solución para el
                w-ésimo peso, tomando en cuenta hasta el i-artículo */
                if (this.articulos.get(i - 1).getPeso() <= w) {
                    /* Ahora se pregunta, si el máximo beneficio hasta el
                    (i-1)-artículo es mayor que la suma del beneficio del 
                    nuevo artículo tomado en cuenta y el máximo beneficio
                    calculado para el peso que hace completar w, es decir:
                    w - (peso del nuevo artículo que se toma en cuenta) */
                    if (this.matrizBeneficios[i - 1][w]
                            > this.articulos.get(i - 1).getBeneficio()
                            + this.matrizBeneficios[i - 1][w - this.articulos.get(i - 1).getPeso()]) {
                        // Si es así, entonces el máximo beneficio, será el mismo que
                        // caculado tomando en cuenta hasta el (i-1)-artículo
                        this.matrizBeneficios[i][w] = this.matrizBeneficios[i - 1][w];
                    } else {
                        /* De otra manera, hay mayor beneficio sumando el beneficio 
                        del nuevo artículo que se toma en cuenta y el beneficio 
                        máximo calculado para el peso que complementa el peso
                        del nuevo artículo que se toma en cuenta. */
                        this.matrizBeneficios[i][w]
                                = this.articulos.get(i - 1).getBeneficio()
                                + this.matrizBeneficios[i - 1][w - this.articulos.get(i - 1).getPeso()];
                    }
                } /* De otra manera, el máximo beneficio para el w-ésimo peso tomando
                en cuenta hasta el i-artículo será el calculado para el 
                (i-1)-artículo */ else {
                    this.matrizBeneficios[i][w] = this.matrizBeneficios[i - 1][w];
                }
            }
        }
    }

    public int consultarMaximoBeneficio(int peso) {
        return this.matrizBeneficios[this.articulos.size()][peso];
    }

    public String obtenerCombinacionMaximizadora(int peso) {
        // No funciona correctamente
        int pesoAcumulado = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = this.articulos.size(); i >= 1; i--) {
            if (this.matrizBeneficios[i][peso] != this.matrizBeneficios[i - 1][peso]
                && pesoAcumulado + this.articulos.get(i-1).getPeso() <= peso) {
                ans.append('1');
                pesoAcumulado += this.articulos.get(i-1).getPeso();
            } 
            else ans.append('0');
        }
        return ans.reverse().toString();
    }

    public long getTotalTime() {
        return totalTime;
    }

    public static void main(String[] args) {
        Articulo a1 = new Articulo(3, 2);
        Articulo a2 = new Articulo(10, 4);
        Articulo a3 = new Articulo(5, 1);
        Articulo a4 = new Articulo(15, 3);

        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos.add(a1);
        articulos.add(a2);
        articulos.add(a3);
        articulos.add(a4);

        MochilaDinamica md = new MochilaDinamica();
        System.out.println("Máximo beneficio: " 
            + md.calcularMayorBeneficio(articulos, 5));
        System.out.println("Combinación maximizadora: "
            + md.obtenerCombinacionMaximizadora(5));
    }
}
