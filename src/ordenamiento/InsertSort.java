package ordenamiento;
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
        double key;
        int j;
        for (int i = 1; i < data.length; i++) {
            key = data[i];
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
}
