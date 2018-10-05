/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

/**
 *
 * @author david
 */
public interface SearchAlgorithm {
    public int buscar(char[] caracteres, char c);
    public long getTotalTime();
}
