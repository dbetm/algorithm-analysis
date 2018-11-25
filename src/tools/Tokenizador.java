package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Tokenizador {
    public static ArrayList<Articulo> articulos;
   /* public static double cantCarac()
    {
        return articulos.get(0);
    }*/
    public static void leerDatos(){
        articulos = new ArrayList<>();
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
        
         try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                double clase;
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    //double[] peso = new double[lista2.size() - 1];
                   int peso;

                    //for (int x = 0; x < lista2.size() - 1; x++) {
                        peso = Integer.parseInt(lista2.get(lista2.size()-2));
                    //}

                    clase = Double.parseDouble(lista2.get(lista2.size()-1));
                    // a la coleccion de patrones se agrega un nuevo patron
                    articulos.add(new Articulo(peso, (int)clase));
                   // patrones.add();
                    lista2.clear();

                }
          
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
    }
}
