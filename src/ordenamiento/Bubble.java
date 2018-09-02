package ordenamiento;

 /* @author david */
public class Bubble implements SortAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;

    public Bubble() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }
    
    @Override
    public void sort(double[] data) {
        this.initTime = System.currentTimeMillis();
        double temp;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                // Se compara
                if(data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j + 1] = temp;
                }
            }
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
    }

    @Override
    public long getTotalTime() {
        return totalTime;
    }
}
