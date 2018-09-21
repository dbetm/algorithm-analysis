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
        double key;
        int j;
        for (int i = 1; i < n; i++) {
            key = data[i];
            // y asignación.
            j = i - 1;
            
            /* Se mueven hacia adelante los elementos de data[0,...i-1]
            hasta que la llave sea mayor o igual que data[j]
            */
            while(j >= 0 && data[j] > key) {
                data[j+1] = data[j];
                j--;
            }
            // Insertamos la llave en donde corresponde
            data[j + 1] = key;
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
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
