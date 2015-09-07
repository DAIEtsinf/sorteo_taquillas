package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import lib.MArrayList;
import lib.MList;

public class SortearTaquillas {

    private MList<Persona> listaPersonas, listaDAI;

    public SortearTaquillas() {
        this.listaPersonas = new MArrayList<Persona>();
        this.listaDAI = new MArrayList<Persona>();
    }

    public MList sortear(String archivoPersonas, String archivoDAI) throws LogicalException {
        //Leemos los archivos
        leerArchivos(archivoPersonas, archivoDAI);

        //Comprobamos que no hay duplicados
        listaPersonas = listaPersonas.removeDuplicates();

        //Comprobamos que no hay miembros de la DAI entre los participantes
        listaPersonas = listaPersonas.removeElements(listaDAI);
        
        //Realizamos el sorteo
        return listaPersonas.randomize();
    }
    
    
    private void leerArchivos(String archivoPersonas, String archivoDAI) throws LogicalException {
        archivoPersonas = "C:\\Users\\Oscar\\git\\sorteo_taquillas\\files\\Nombres.txt";
        archivoDAI = "C:\\Users\\Oscar\\git\\sorteo_taquillas\\files\\AlumnosDAI.txt";

        try {
            FileReader fr = null;
            BufferedReader br = null;

            //Leemos los participantes
            try {

                fr = new FileReader(new File(archivoPersonas));

                br = new BufferedReader(fr);

                String linea;
                while ((linea = br.readLine()) != null) {
                    listaPersonas.add(new Persona(linea));
                }
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

                fr = new FileReader(new File(archivoDAI));
                br = new BufferedReader(fr);

                String linea;
                while ((linea = br.readLine()) != null) {
                    listaDAI.add(new Persona(linea));
                }
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
