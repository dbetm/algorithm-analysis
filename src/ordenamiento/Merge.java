package ordenamiento;

import tools.GenerarDatos;

/**
 *
 * @author david
 */
public class Merge implements SortAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;
    private double[] datos;
    private int contMerge;
    
    // Constructor
    public Merge() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
        this.contMerge = 0;
    }

    @Override
    public void sort(double[] arreglo) {
        this.datos = arreglo.clone();
        // Tomamos el tiempo de inicio, necesario para medir la eficiencia 
        // sobre el tiempo del algoritmo
        this.initTime = System.currentTimeMillis();
        /* Se manda llamar por primera vez el método ordenar sus parámetros son 
        el subarreglo (en este caso, todo el arreglo) un puntero inferior y 
        uno superior, necesarios para delimitar el subarreglo */
        ordenar(arreglo, 0, arreglo.length - 1);
        //Se toma el tiempo de cuando finalizó el algoritmo
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
    }
    
    private void ordenar(double[] tempArray, int left, int right) {
        // Se verifica que left sea menor que right
        if(left < right) { // Caso base
             // ## Divide
            // Se calcula la mitad y se redondea hacia abajo
            int center = (left + right) / 2;
            // Se hace la llamada recursiva para ordenar los dos subarreglos
            // el que está a la izquierda de center y el que está a la derecha
            
            // Caso recursivo.
            
            // Ordenar subarreglo de la izquierda de center
            ordenar(tempArray, left, center);
            
            // Ordenar subarreglo de la derecha de center
            ordenar(tempArray, center + 1, right);
            
            // ## Combina, args: subarreglo
                // subarreglo: arreglo, ptr inicio, prtMitad + 1, ptrFinal
            merge(tempArray, left, center + 1, right);
        }
    }
    
    private void merge(double []tempArray, int leftPos, int rightPos, int rightEnd) {
        this.contMerge++;
        // Establecer unos límites
            // Para saber donde termina el subarreglo de la izquierda
        int leftEnd = rightPos - 1;
            // Posición temporal, se inicializa con la posición de la izquierda
        int tempPos = leftPos;
        // Calcular el número de elementos a combinar
        int numElementos = rightEnd - leftPos + 1;
        
        // Generar los cambios en el arreglo temporal, con ayuda de this.datos
            /* Mientras la posición del subarreglo de la izquierda sea menor o 
                igual al puntero del final de la izquierda y mientras la posición
                del subarreglo de la derecha sea menor o igual al final de la derecha.
            */
        while(leftPos <= leftEnd && rightPos < rightEnd) {
            // Compara los datos de cada subarreglo, si el de la izquierda es
            // menor al dato de la derecha, entonces lo agrega al arreglo temporal 
            // en la posición de temp, y la posición temporal se incrementa en uno
            if(this.datos[leftPos] < this.datos[rightPos]) {
                tempArray[tempPos++] = this.datos[leftPos++];
            }
            else {
                tempArray[tempPos++] = this.datos[rightPos++];
            }
        }
        
        // Dado que pueden no tener el mismo tamaño
            // Se copia el resto de la primera mitad
        while(leftPos <= leftEnd) {
            tempArray[tempPos++] = this.datos[leftPos++];
        }
            // Se copia el resto de la segunda mitad
        while(rightPos <= rightEnd) {
            tempArray[tempPos++] = this.datos[rightPos++];
        }
        
        // Que se cumpla alguna vez la condición de los whiles anteriores
        // los hace mutuamente excluyentes.
        
        // Se actualiza el arreglo original
        for (int i = 0; i < numElementos; i++, rightEnd--) {
            this.datos[rightEnd] = tempArray[rightEnd];
        }
        
    }

    @Override
    public long getTotalTime() {
        return this.totalTime;
    }
    
    public static void main(String []args) {
        Merge mSort = new Merge();
    }
    
}
