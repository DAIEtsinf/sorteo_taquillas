package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import lib.MArrayList;
import lib.MList;

/**
 * Clase que representa el sorteo de taquillas.
 */
public class SortearTaquillas {
    //Listas utilizadas para el sorteo
    private MList<Persona> listaPersonas, listaDAI;

    /**
     * Constructor de la clase.
     */
    public SortearTaquillas() {
        this.listaPersonas = new MArrayList<Persona>();
        this.listaDAI = new MArrayList<Persona>();
    }

    /**
     * Metodo principal de la clase. Este metodo lee los archivos, rellenando
     * las listas y opera con ellas para eliminar duplicados y los miembros de
     * la delegacion de alumnos de los posibles ganadores.
     * @param archivoParticipantes String que representa la ruta del archivo de participantes.
     * @param archivoMiembrosDAI
     * @return
     * @throws LogicalException 
     */
    public MList sortear(String archivoParticipantes, String archivoMiembrosDAI) throws LogicalException {
        //Leemos los archivos y rellenamos las listas
        leerArchivos(archivoParticipantes, archivoMiembrosDAI);

        //Eliminamos los duplicados
        listaPersonas = listaPersonas.removeDuplicates();

        //Eliminamos los miembros de la DAI de los participantes
        listaPersonas = listaPersonas.removeElements(listaDAI);
        
        //Realizamos el sorteo
        return listaPersonas.randomize();
    }
    
    
    /**
     * Metodo que lee los archivos y rellena las listas.
     * @param archivoParticipantes String que representa la ruta del archivo de los participantes.
     * @param archivoMiembrosDAI String que representa la ruta del archivo de los miembros de la DAI.
     * @throws LogicalException Excepcion lanzada cuando se intenta crear una persona a partir de los archivos de forma erronea.
     */
    private void leerArchivos(String archivoParticipantes, String archivoMiembrosDAI) throws LogicalException {
        try {
            FileReader fr = null;
            BufferedReader br = null;

            //Leemos los participantes
            try {

                fr = new FileReader(new File(archivoParticipantes));
                br = new BufferedReader(fr);

                String linea;
                while ((linea = br.readLine()) != null) 
                    listaPersonas.add(new Persona(linea));
                
            } finally {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }

            //Leemos los miembros de la Delegacion de Alumnos de Informatica
            try {

                fr = new FileReader(new File(archivoMiembrosDAI));
                br = new BufferedReader(fr);

                String linea;
                while ((linea = br.readLine()) != null)
                    listaDAI.add(new Persona(linea));
                
            } finally {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        } catch (IOException ex) {
            throw new LogicalException(ex.getMessage());
        }
    }
}