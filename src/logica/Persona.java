package logica;

/**
 * Clase que representa a los alumnos que participan en el sorteo.
 */
public class Persona {

    //Nombre del participante
    private String nombre;
    //DNI o identificador del participante
    private String dni;

    /**
     * Constructor de la clase Persona.
     * @param nombre String que representa el nombre de la persona.
     * @param dni String que representa el dni de la persona.
     */
    public Persona(String nombre, String dni){
        setNombre(nombre);
        setDNI(dni);
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param txt debe de tener el formato "nombre, DNI"
     * @throws logica.LogicalException Excepcion lanzada si el parametro de
     * entrada no contiene comas.
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
     * @param nombre String que representa el nuevo nombre de la persona.
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
     * @param dni String que representa el nuevo DNI de la persona.
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
    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", DNI: " + getDNI();
    }

    /**
     * Método que permite comprar las personas. No se comparar los nombres
     * puesto que puede haber dos personas con el mismo nombre. Se intenta tener
     * en cuenta el caso en que una persona primero se anyada con dni sin letra
     * y despues se anyada con dni con letra, se reconoce siempre que tenga el
     * mismo nombre. Si el parametro de entrada no es de la clase Persona se
     * devuelve false.
     *
     * @param o personas con la que comparamos.
     * @return boleean que representa si dos personas son la misma.
     */
    @Override
    public boolean equals(Object o) {
        if(!o.getClass().toString().
                equals("class logica.Persona"))return false;
        Persona p = (Persona)o;
        if(p == null)return false;
      
        //if(this.getNombre().equals(p.getNombre())) return true;
        if (this.getDNI().toUpperCase().equals(p.getDNI().toUpperCase()))
            return true;

        //Caso en que dos personas se llamen igual y una contenga el DNI de otra
        //Seguramente han añadido el DNI sin la letra y después la han puesto
        if(this.nombre.toUpperCase().equals(p.getNombre().toUpperCase()) && this.getDNI().toUpperCase().contains(p.getDNI().toUpperCase()))
            return true;
        
        return false;
    }
}
