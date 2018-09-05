package ordenamiento;

import tools.GenerarDatos;

/**
 *
 * @author david
 */
public class InsertSort implements SortAlgorithm{
    private long initTime;
    private long endTime;
    private long totalTime;

    public InsertSort() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }
    
    @Override
    public void sort(double[] data) {
        this.initTime = System.currentTimeMillis();
        int n = data.length;
        //Contando el número de operaciones
        int cont = 0;
        double key;
        int j;
        for (int i = 1; i < n; i++) {
            cont += 3; // por las 3 operaciones que implica el ciclo for.
            key = data[i];
            cont += 2; // por las 2 operaciones que implica el acceso a memoria
            // y asignación.
            j = i - 1;
            cont += 2; // por las 2 operaciones, resta y asignación.
            
            /* Se mueven hacia adelante los elementos de data[0,...i-1]
            hasta que la llave sea mayor o igual que data[j]
            */
            while(j >= 0 && data[j] > key) {
                cont += 4; // por las 4 operaciones del ciclo while
                data[j+1] = data[j];
                cont += 4; // suma, acceso a memoria, acceso a memoria y asignación
                j--;
                cont++; // operación de incremento, se considera 1
            }
            // Insertamos la llave en donde corresponde
            data[j + 1] = key;
            cont += 3; // suma, acceso a memoria y asignación
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        // El muestra el número de operaciones contadas
        System.out.println("Númeor de operaciones: " + cont);
    }

    @Override
    public long getTotalTime() {
        return totalTime;
    }
    
    public static void main(String []args) {
        InsertSort is = new InsertSort();
        
        is.sort(GenerarDatos.generarDatosMejorCaso(17));
        is.sort(GenerarDatos.generarDatosPeorCaso(17));
    }
}
