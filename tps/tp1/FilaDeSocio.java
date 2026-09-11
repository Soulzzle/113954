package tp1;

/**
 * FilaDeSocio es un registro inmutable que agrupa los datos consolidados 
 * de un socio para su posterior volcado en el reporte.
 * @param padron el número identificador del socio.
 * @param socio el nombre completo del socio.
 * @param prestamos la cantidad total de préstamos asociados a este padrón.
 * @param diasDeAtraso la suma total de días de atraso de todos sus préstamos.
 * @param multa el monto total acumulado por penalizaciones.
 * @param estado la condición final del socio ("CON_DEUDA" o "AL_DIA").
 */
public record FilaDeSocio(int padron, String socio, int prestamos, int diasDeAtraso, int multa, String estado) implements Comparable<FilaDeSocio> {
   
    // METODOS DE COMPORTAMIENTO
    /**
     * compareTo define la regla de ordenamiento para las filas.
     * Prioriza la multa de mayor a menor y desempata alfabéticamente por el nombre del socio.
     * @param otra la fila contra la cual se compara la instancia actual.
     * @return un entero negativo, cero o positivo según el criterio de ordenamiento.
     */
    @Override
    public int compareTo(FilaDeSocio otra) {
        if (this.multa != otra.multa) {
            return Integer.compare(otra.multa, this.multa); 
        }
        return this.socio.compareTo(otra.socio);
    }
}
