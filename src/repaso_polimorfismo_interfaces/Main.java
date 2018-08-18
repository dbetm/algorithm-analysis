package repaso_polimorfismo_interfaces;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Main {

    public static void main(String []args) {
        // Polimorfismo
        Persona juan = new Alumno();
        Persona laura = new Profesor();
        //recibirPersona(juan);
        
        ArrayList<Persona> invitados = new ArrayList<>();
        invitados.add(juan);
        invitados.add(laura);
        for (Persona invitado : invitados) {
            recibirPersona(invitado);
        }
    }

    private static void recibirPersona(Persona persona) {
        if(persona instanceof Alumno)
            persona.saludar();
    }
    
}
