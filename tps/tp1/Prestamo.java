package tp1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public record Prestamo(LocalDate retiro, int padron, String socio, String isbn, String titulo, LocalDate devolucion){

    private static final int DEUDA_POR_DIA = 150;
    private static final int TOPE_MULTA = 3000;

    //CONSTRUCTORES -------------------------------------------------------------------------------------------

    public Prestamo{
        Objects.requireNonNull(retiro, "El dato retiro no puede ser nulo.");
        Objects.requireNonNull(socio, "El dato socio no puede ser nulo.");
        Objects.requireNonNull(isbn, "El dato isbn no puede ser nulo.");
        Objects.requireNonNull(titulo, "El dato titulo no puede ser nulo.");

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
    public boolean estaPendiente(){
        return devolucion == null;
    }
    public LocalDate vencimiento(){ // retiro + 14 dias
        return retiro.plusDays(14);
    }
    public int diasDeAtraso(LocalDate corte){ // siempre >= {
        long dias;
        if (estaPendiente()){
            dias = ChronoUnit.DAYS.between(vencimiento(), corte);
        } else{
            dias = ChronoUnit.DAYS.between(vencimiento(), devolucion);
        }
        return Math.max((int) dias, 0);
    }
    public int multa(LocalDate corte){ // 150 por dia, tope 3000
        int diasAtraso = diasDeAtraso(corte);
        int multa = DEUDA_POR_DIA * diasAtraso;
        return Math.min(multa, TOPE_MULTA);
    }
}
