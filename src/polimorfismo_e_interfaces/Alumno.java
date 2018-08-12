package polimorfismo_e_interfaces;

/**
 *
 * @author david
 */
public class Alumno implements Persona {

    @Override
    public void saludar() {
        System.out.println("Hola, soy un alumno.");
    }
    
}
