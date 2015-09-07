package logica;

/**
 * Excepcion lanzada cuando se produce algun error en la capa logica.
 */
public class LogicalException extends Exception {
    /**
     * Constructor de la clase.
     * @param msg String que representa el mensaje amigable que lanza la excepcion.
     */
    public LogicalException(String msg){
        super(msg);
    }
}
