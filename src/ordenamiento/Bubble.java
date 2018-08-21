package ordenamiento;

 /* @author david */
public class Bubble {
    private long initTime;
    private long endTime;
    private long totalTime;

    public Bubble() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }
    
    public void sort(double[] data) {
        this.initTime = System.currentTimeMillis();
        double temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                // Ask... 
                if(data[j] > data[j +1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
