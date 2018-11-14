/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programacion_dinamica;

import java.util.ArrayList;
import tools.Articulo;

/**
 *
 * @author david
 */
public class FuerzaBrutaMochilaEntera {
    private long initTime;
    private long endTime;
    private long totalTime;
    String combinacion;
    
    public FuerzaBrutaMochilaEntera() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
        this.combinacion = "";
    }
    
    public int calcularMayorBeneficio(ArrayList<Articulo> articulos, int _W) {
        int beneficio = 0;
        this.combinacion = "";
        String enBinario = "";
        
        this.initTime = System.currentTimeMillis();
        
        // Iteramos hasta 2^n
        for (int i = 1; i < (1 << articulos.size()); i++) {
            int pesoAcumulado = 0;
            int beneficioAcumulado = 0;
            for (int j = articulos.size() - 1; j >= 0; j--) {
                int ans = 1 & (i >> j);
                if(ans == 1) {
                    pesoAcumulado += articulos.get(j).getPeso();
                    beneficioAcumulado += articulos.get(j).getBeneficio();
                    if(pesoAcumulado > _W) break;
                }
            }
            if(pesoAcumulado > _W) {
                //System.out.println("Excede el peso de " + _W);
            }
            else {
                if(beneficio < beneficioAcumulado) {
                    enBinario = Integer.toBinaryString(i);
                    beneficio = beneficioAcumulado;
                }
            }
        }
        
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        
        this.combinacion = getZeros(articulos.size() - enBinario.length()) 
            + enBinario;
        return beneficio;
    }
    
    private String getZeros(int n) {
        return new String(new char[n]).replace('\0', '0');
    }
    
    public long getTotalTime() {
        return totalTime;
    }
    
    public String obtenerCombinacionMaximizadora(int peso) {
        StringBuilder input1 = new StringBuilder();
        // append a string into StringBuilder input1 
        input1.append(this.combinacion); 
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
        // print reversed String 
        return input1.toString();
    }

    
    public static void main(String []args) {
        Articulo a1 = new Articulo(15, 34);
        Articulo a2 = new Articulo(4, 20);
        Articulo a3 = new Articulo(3, 100);
        Articulo a4 = new Articulo(56, 780);
        Articulo a5 = new Articulo(23, 60);
        Articulo a6 = new Articulo(4, 50);
        /*Articulo a1 = new Articulo(35, 4);
        Articulo a2 = new Articulo(10, 4);
        Articulo a3 = new Articulo(5, 1);
        Articulo a4 = new Articulo(1, 3);*/
        // Se genera un arreglo de articulos de tamaño 3, con 5 de peso máx
        //ArrayList<Articulo> articulos = Articulo.generarArticulos(5, 3);
        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos.add(a1);
        articulos.add(a2);
        articulos.add(a3);
        articulos.add(a4);
        articulos.add(a5);
        articulos.add(a6);
        Articulo.imprimirArticulos(articulos);
        
        FuerzaBrutaMochilaEntera mochila = new FuerzaBrutaMochilaEntera();
        int beneficio = mochila.calcularMayorBeneficio(articulos, 80);
        System.out.println("Beneficio: " + beneficio);
        System.out.println("Combinación maximizadora: " 
            + mochila.obtenerCombinacionMaximizadora(80));
    }
}
