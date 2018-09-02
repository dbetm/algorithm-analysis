package ordenamiento;
/**
 *
 * @author david
 */
public class OptBubble implements SortAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;

    public OptBubble() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }

    @Override
    public void sort(double[] data) {
        // El burbuja siempre tiene un tiempo O(n^2) indiferente a si ya el
        // arreglo está ordenado o no, es por ello que se optimiza
        // detectando este caso en el burbuja optimizado.
        this.initTime = System.currentTimeMillis();
        double temp;
        boolean swapped;
        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if(data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break; // Ya está ordenado
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
    }

    @Override
    public long getTotalTime() {
        return totalTime;
    }
    
    public static void main(String[] args) {
        // Prueba unitaria #1
        OptBubble ob = new OptBubble();
        ob.sort(new double[]{1,2,3,4,5,6,7.2});
        System.out.println("");
    }
    
}
