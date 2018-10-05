package busqueda;

/**
 *
 * @author david
 */
public class Binaria implements SearchAlgorithm {
    private long initTime;
    private long endTime;
    private long totalTime;
    private int ans = -1; // para la versión 2
    
    public Binaria() {
        this.initTime = 0;
        this.endTime = 0;
        this.totalTime = 0;
    }

    @Override
    public int buscar(char[] caracteres, char c) {
        this.initTime = System.currentTimeMillis();
        int index;
        
        //this.ans = index = binarySearch(caracteres, c, 0, caracteres.length - 1);
        binarySearchV2(caracteres, 0, caracteres.length - 1, c, 0);
        
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.initTime;
        return this.ans;
    }
    
    private int binarySearch(char[] caracteres, char c, int index, int n) {
        int i = (index + n) / 2;
        if(i > n) return -1;
        else if(caracteres[i] == c) return i;
        else if(caracteres[i] < c) index = i + 1;
        else n = i - 1;
        return binarySearch(caracteres, c, index, n);
    }
    
    private void binarySearchV2(char[] chars, int left, int right, char c, int i) {
        if(chars[i] == c) {
            this.ans = i;
            return;
        }
        if(left < right) {
            int center = (left + right) / 2;
            binarySearchV2(chars, left, center, c, left);
            binarySearchV2(chars, center + 1, right, c, center + 1);
        }
    }

    @Override
    public long getTotalTime() {
        return this.totalTime;
    }
    
    public static void main(String []args) {
        Binaria b = new Binaria();
        int pos = b.buscar(new char[]{'!', '!', '!', '!', '!', '!', '!', '#'}, '#');
        System.out.println(pos);
    }
    
}
