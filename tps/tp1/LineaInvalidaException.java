package tp1;

/**
 * LineaInvalidaException representa un error de formato o validación 
 * al procesar una línea del archivo de entrada.
 */
public class LineaInvalidaException extends RuntimeException {
    
    private final int numeroDeLinea;

    /**
     * LineaInvalidaException es el constructor que asocia la línea problemática 
     * con la causa específica del rechazo.
     * @param numeroDeLinea la posición real de la línea en el archivo original.
     * @param motivo la descripción detallada del error encontrado.
     */
    public LineaInvalidaException(int numeroDeLinea, String motivo) {
        super(motivo);
        this.numeroDeLinea = numeroDeLinea;
    }

    /**
     * numeroDeLinea informa en qué línea exacta del archivo ocurrió el error.
     * @return el número de línea.
     */
    public int numeroDeLinea() {
        return this.numeroDeLinea;
    }
}
