package logica;

/**
 * Clase que representa a los alumnos que participan en el sorteo
 *
 * @author Oscar
 */
public class Persona {

    //Nombre del participante
    private String nombre;
    //DNI o identificador del participante
    private String dni;

    /**
     * Constructor de la clase Persona.
     * @param nombre
     * @param dni 
     */
    public Persona(String nombre, String dni){
        setNombre(nombre);
        setDNI(dni);
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param txt debe de tener el formato "nombre, DNI"
     * @throws Exception
     */
    public Persona(String txt) throws LogicalException {
        if (!txt.contains(",")) {
            throw new LogicalException("El texto para crear un participante debe de contener una coma");
        }
        //Obtiene el texto hasta la coma        
        setNombre(txt.substring(0, txt.indexOf(",")));
        //Obtiene todo el texto a partir de la coma
        setDNI(txt.substring(txt.indexOf(",") + 1));
    }

    /**
     * Método para guardar el nombre del Persona.
     *
     * @param nombre
     */
    private void setNombre(String nombre) {
        while (nombre.charAt(0) == ' ' || nombre.charAt(nombre.length()-1) == ' ')
            nombre = nombre.trim();
        this.nombre = nombre;
    }

    /**
     * Método para guardar el DNI o el identificador de la persona. No se pueden
     * añadir restricciones, ya que algunos estudiantes de intercambio no tienen
     * DNI y suelen utilizar pasaporte u otros identificadores.
     *
     * @param dni
     * @throws Exception
     */
    private void setDNI(String dni){
        while (dni.charAt(0) == ' ' || dni.charAt(dni.length()-1) == ' ') 
            dni = dni.trim();
        this.dni = dni;
    }

    /**
     * Método para obtener el nombre del participante.
     *
     * @return String que representa el nombre del participante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el DNI del participante.
     *
     * @return String que representa el DNI del participante.
     */
    public String getDNI() {
        return this.dni;
    }

    /**
     * Método que permite imprimir por pantalla la clase Persona junto con sus
     * atributos.
     *
     * @return String con el formato "Nombre: "+nombre+", DNI: "+dni
     */
    public String toString() {
        return "Nombre: " + getNombre() + ", DNI: " + getDNI();
    }

    /**
     * Método que permite comprar los participantes. Compara los DNI, también
     * tiene en cuenta el caso en que haya un DNI con letra y un DNI sin letra.
     * No se comparar los nombres puesto que puede haber dos personas con el
     * mismo nombre.
     *
     * @param p participante con el que comparamos
     * @return boleean que representa si dos participantes son iguales.
     */
    public boolean equals(Persona p) {
        if(p == null)return false;
        
        //if(this.getNombre().equals(p.getNombre())) return true;
        if (this.getDNI().equals(p.getDNI())) {
            return true;
        }

        //Caso en que dos personas se llamen igual y una contenga el DNI de otra
        //Seguramente han añadido el DNI sin la letra y después la han puesto
        if(this.nombre.equals(p.getNombre()) && this.getDNI().contains(p.getDNI()))
            return true;
        
        return false;
    }
}
