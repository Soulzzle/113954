package tp1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Prestamo representa un préstamo de parte de la biblioteca.
 */
public record Prestamo(LocalDate retiro, int padron, String socio, String isbn, String titulo, LocalDate devolucion){

    private static final int DEUDA_POR_DIA = 150;
    private static final int TOPE_MULTA = 3000;

    //CONSTRUCTORES -------------------------------------------------------------------------------------------

    /**
     * Prestamo es el constructor compacto que valida que las invariantes del préstamo no esten vacías o nulas.
     * @throws IllegalArgumentException si los datos de texto están vacíos, el padrón no es positivo, o la devolución es anterior al retiro.
     * @throws NullPointerException si retiro, socio, isbn o titulo son nulos.
     */
    public Prestamo{
        if (retiro == null) {
            throw new NullPointerException("El dato retiro no puede ser nulo.");
        }
        if (socio == null) {
            throw new NullPointerException("El dato socio no puede ser nulo.");
        }
        if (isbn == null) {
            throw new NullPointerException("El dato isbn no puede ser nulo.");
        }
        if (titulo == null) {
            throw new NullPointerException("El dato titulo no puede ser nulo.");
        }

        if (socio.isBlank()){
            throw new IllegalArgumentException("El dato socio no puede estar vacío.");
        }
        if (isbn.isBlank()){
            throw new IllegalArgumentException("El dato isbn no puede estar vacío.");
        }
        if (titulo.isBlank()){
            throw new IllegalArgumentException("El dato titulo no puede estar vacío.");
        }
        if (padron <= 0){
            throw new IllegalArgumentException("El padrón debe ser positivo.");
        }
        if (devolucion != null){
            if (devolucion.isBefore(retiro)){
                throw new IllegalArgumentException("devolucion no puede ser anterior a retiro.");
            }
        }
    }

    //METODOS DE COMPORTAMIENTO -------------------------------------------------------------------------------

    /**
     * estaPendiente valida si el préstamo fue devuelto o no.
     * @return true si la fecha de devolución es nula, false en caso contrario.
     */
    public boolean estaPendiente(){
        return devolucion == null;
    }

    /**
     * vencimiento calcula la fecha de vencimiento del préstamo (14 días desde el retiro).
     * @return la fecha límite de devolución esperada.
     */
    public LocalDate vencimiento(){
        return retiro.plusDays(14);
    }

    /**
     * diasDeAtraso calcula los días de atraso desde el vencimiento.
     * Si no hay atraso, devuelve 0.
     * @param corte la fecha hasta la que se calcula el atraso si el préstamo está pendiente.
     * @return cantidad de días de atraso.
     */
    public int diasDeAtraso(LocalDate corte){
        long dias;
        if (estaPendiente()){
            dias = ChronoUnit.DAYS.between(vencimiento(), corte);
        } else{
            dias = ChronoUnit.DAYS.between(vencimiento(), devolucion);
        }
        return Math.max((int) dias, 0);
    }

    /**
     * multa calcula la multa correspondiente a los días de atraso.
     * @param corte la fecha de corte para el cálculo en préstamos pendientes.
     * @return el monto de la multa calculada, respetando el máximo de deuda posible
     */
    public int multa(LocalDate corte){
        int diasAtraso = diasDeAtraso(corte);
        int multa = DEUDA_POR_DIA * diasAtraso;
        return Math.min(multa, TOPE_MULTA);
    }
}
