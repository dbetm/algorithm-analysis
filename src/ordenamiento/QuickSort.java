package ordenamiento;

/**
 *
 * @author David Betancourt Montellano
 */
public class QuickSort implements SortAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;

    public QuickSort() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }

    @Override
    public void sort(double[] data) {
        // Se verifica que los datos no sean nulos y data tenga al menos un dato
        if(data != null && data.length > 0) {
            // Se toma el tiempo incial
            this.initTime = System.currentTimeMillis();
            // Se manda llamar el método del ordenamiento
            // los parámetros: el subarreglo, lím inferior y superior
            ordenar(data, 0, data.length - 1);
            // Se toma el tiempo final
            this.endTime = System.currentTimeMillis();
        }
        // Se calcula el tiempo total
        this.totalTime = this.initTime - this.initTime;
    }
    
    public void ordenar(double[] tmpArray, int left, int right) {
        // Se selecciona el pivote, se puede seleccionar cualquiera, en este caso
        // se selecciona el elemento de más a la izquierda (el primero del subarreglo).
        double pivote = tmpArray[left];
        // Se declara el índice para hacer la búsqueda de izquierda a derecha
        int l = left;
        // Se declara el índice para hacer la búsqueda de derecha a izquierda
        int r = right;
        // Se declara un auxiliar para el intercambio
        double aux;
        
        // Mientras no se crucen las búsquedas
        while(l < r) {
            // Se busca un elemento mayor o igual al pivote
            while(tmpArray[l] <= pivote && l < r) l++;
            
            // Se busca un elemento menor al privote
            while(tmpArray[r] > pivote) r--;
            
            // Si no se han cruzado se hace el intercambio
            if(l < r) {
                aux = tmpArray[l];
                tmpArray[l] = tmpArray[r];
                tmpArray[r] = aux;
            }
        }
        
        // Se coloca el pivote en su lugar: De modo que tendremos los menores a 
        // su izquierda y los mayores a su derecha.
        tmpArray[left] = tmpArray[r];
        tmpArray[r] = pivote;
        // ## Caso base
        // Se ordena el sub-arreglo de la izquierda
        if(left < r - 1)
            ordenar(tmpArray, left, right - 1);
        // Se ordena el sub-arreglo de la derecha
        if(r + 1 < right)
            ordenar(tmpArray, r + 1, right);
    }

    @Override
    public long getTotalTime() {
        return this.totalTime;
    }
    
    
}
