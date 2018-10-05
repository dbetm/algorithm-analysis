package busqueda;

/**
 *
 * @author david
 */
public class Lineal implements SearchAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;
    
    public Lineal() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }
    
    // Busca el elemento en el arreglo de caracteres
    // si lo encuentra retorna su posición, en otro caso
    // retorna -1
    @Override
    public int buscar(char[] caracteres, char c) {
        this.initTime = System.currentTimeMillis();
        int index = -1;
        
        for (int i = 0; i < caracteres.length; i++) {
            if(c == caracteres[i]) {
                index = i;
                break;
            }
        }
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        return index;
    }

    @Override
    public long getTotalTime() {
        return this.totalTime;
    }
    
    public static void main(String []args) {
        Lineal l = new Lineal();
        int pos = l.buscar(new char[]{'!', '!', '!', '!', '!', '!', '!', '#'}, '#');
        System.out.println(pos);
    }

}
