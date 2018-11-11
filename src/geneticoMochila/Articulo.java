package geneticoMochila;

/**
 *
 * @author david
 */
public class Articulo {
    private int peso;
    private double beneficio;
    
    public Articulo() {
        this.peso = 0;
        this.beneficio = 0;
    }

    public Articulo(int peso, double beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }
}
