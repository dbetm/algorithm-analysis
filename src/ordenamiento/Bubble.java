package ordenamiento;

import tools.GenerarDatos;

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
        int cont = 0;
        for (int i = 1; i < data.length; i++) {
            cont += 3;
            for (int j = 0; j < data.length - 1; j++) {
                cont += 8;
                // Se compara
                if(data[j] > data[j+1]) {
                    cont += 9;
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j + 1] = temp;
                }
            }
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        System.out.println("Número de operaciones: " + cont);
    }

    @Override
    public long getTotalTime() {
        return totalTime;
    }
    
    public static void main(String []args) {
        Bubble b = new Bubble();
        b.sort(GenerarDatos.generarDatosMejorCaso(17));
        b.sort(GenerarDatos.generarDatosPeorCaso(17));
    }
}
