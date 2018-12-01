package avidos;

import tools.Coordenada;

/**
 *
 * @author david
 */
public class CaballoAjedrez {
    private int[][] tablero;
    private final int n;
    private Coordenada c;

    public CaballoAjedrez(int n) {
        this.n = n;
    }

    public boolean esSolucion(Coordenada coordenadaInicial) {
        this.c = coordenadaInicial;
        this.tablero = new int[this.n][this.n];
        boolean ans;
        int i;
        for (i = 1; i <= this.n*this.n; i++) {
            this.tablero[this.c.getX()][this.c.getY()] = i;
            if(!nuevoMovimiento(i) && (i < this.n*this.n - 1)) {
                i++;
                break;
            }
        }
        ans = (--i == this.n * this.n);
        //mostrarTablero();
        return ans;
    }
    
    private void mostrarTablero() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // Va ir calculando la nueva casilla a la que salta, siguiendo el principio ávido,
    // devuelve falso si no es posible moverse a una nueva casilla
    private boolean nuevoMovimiento(int x) {
        int accesibles;
        /* 9 porque desde ninguna posición es posible acceder a 9, si no hay ninguna
        nueva casilla disponible se mantendrá el 9, por lo que servirá para dar
        respuesta a si se puede o no un nuevo movimiento */
        int minaccesibles = 9;
        Coordenada solucion = new Coordenada();
        Coordenada nuevaSolucion = new Coordenada();
        // 8 porque en teoría, desde una posición cualquiera, se pueden realizar
        // 8 posibles movimientos en L, se figura como un reloj.
        
        /* Va ir saltando a cada una de las 8 posibilidades, si es válida la posibilidad, 
        entonces va a contar el número de casillas accesibles desde esa posibilidad, 
        tratando de buscar la posibilidad que tenga menos accesibles, esto último es el 
        principio ávido, pues se cree que sí voy eligiendo la que menos accesibles 
        tiene, pues se podrá completar todo el tablero */
        for (int i = 1; i <= 8; i++) {
            if(saltar(this.c, nuevaSolucion, i)) {
                accesibles = contarAccesibles(nuevaSolucion);
                if((accesibles > 0 || (accesibles == 0 && x == this.n * this.n - 1)) 
                    && accesibles < minaccesibles) {
                    minaccesibles = accesibles;
                    solucion.setX(nuevaSolucion.getX());
                    solucion.setY(nuevaSolucion.getY());
                }
            }
        }
        this.c = solucion;
        return (minaccesibles < 9);
    }

    /* ### LAS POSIBILIDADES QUE EL CABALLO TIENE PARA SALTAR SIENDO X UNA COORDENADA
    SE VISUALIZA DE LA SIGUIENTE MANERA:
        |   | 2 |   | 3 |   |
        | 1 |   |   |   | 4 |
        |   |   | x |   |   |
        | 8 |   |   |   | 5 |
        |   | 7 |   | 6 |   |
    */

    /* Calcula las coordenadas de la casilla a donde salta el caballo (tiene 8
    posibilidades), y devuelve si es posible realizar ese movimiento o no (puede
    estar ocupada o salirse del tablero) */
    private boolean saltar(Coordenada actual, Coordenada nuevaSolucion, int opt) {
        /*
        + El caballo se encuentra ahora en la coordenada this.c
        + solucion es para la coordenada a donde salta
        + opt indica el número del movimiento, la i-ésima posibilidad.
        */
        switch(opt) {
            case 1:
                nuevaSolucion.setX(actual.getX() - 2);
                nuevaSolucion.setY(actual.getY() + 1);
                break;
            case 2:
                nuevaSolucion.setX(actual.getX() - 1);
                nuevaSolucion.setY(actual.getY() + 2);
                break;
            case 3:
                nuevaSolucion.setX(actual.getX() + 1);
                nuevaSolucion.setY(actual.getY() + 2);
                break;
            case 4:
                nuevaSolucion.setX(actual.getX() + 2);
                nuevaSolucion.setY(actual.getY() + 1);
                break;
            case 5:
                nuevaSolucion.setX(actual.getX() + 2);
                nuevaSolucion.setY(actual.getY() - 1);
                break;
            case 6:
                nuevaSolucion.setX(actual.getX() + 1);
                nuevaSolucion.setY(actual.getY() - 2);
                break;
            case 7:
                nuevaSolucion.setX(actual.getX() - 1);
                nuevaSolucion.setY(actual.getY() - 2);
                break;
            default:
                nuevaSolucion.setX(actual.getX() - 2);
                nuevaSolucion.setY(actual.getY() - 1);
        }
        /*Se valida que la coordenada esté dentro del tablero y que no haya sido
        visitada antes.*/
        return
            ((nuevaSolucion.getX() < this.n) && (nuevaSolucion.getY() < this.n) &&
                (nuevaSolucion.getX() >= 0) && (nuevaSolucion.getY() >= 0) &&
                    (this.tablero[nuevaSolucion.getX()][nuevaSolucion.getY()] == 0));
    }

    // Devuelve el número de casillas a las que el caballo puede saltar desde una
    // de las 8 posibilidades (nuevaSolucion) que tiene a partir de la actual
    private int contarAccesibles(Coordenada actual) {
        int cont = 0;
        Coordenada nuevaSolucion = new Coordenada();
        for (int i = 1; i <= 8; i++) if(saltar(actual, nuevaSolucion, i)) cont++;
        return cont;
    }

    public static void main(String args[]) {
        // Se declara el algoritmo
        CaballoAjedrez caballo;
        
        // Se prueban 10 diferentes tamaños de tablero
        for (int i = 1; i <= 10; i++) {
            caballo = new CaballoAjedrez(i);
            int n = i;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("N: " + n + ", " + j + ", " + k + " " + 
                        caballo.esSolucion(new Coordenada(j, k)));
                }
            }
            System.out.println("/////////////////////\n");
        }
        
    }
}
