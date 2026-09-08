package tp1;

import java.time.LocalDate;

public record Prestamo(LocalDate retiro, int padron, String socio, String isbn, String titulo, LocalDate devolucion){
    // Valida en el constructor compacto: un Prestamo mal formado NO debe existir.
    //  - socio, isbn y titulo no pueden ser null ni vacios
    //  - padron debe ser positivo
    //  - devolucion puede ser null (pendiente), pero si no lo es,
    //    no puede ser anterior a retiro
    //CONSTRUCTORES -------------------------------------------------------------------------------------------

    public Prestamo{
        if (socio == null || socio.isBlank()){
            throw new IllegalArgumentException("El dato socio no puede estar vacío.");
        }
        if (isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("El dato isbn no puede estar vacío.");
        }
        if (titulo == null || titulo.isBlank()){
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
        LocalDate fechaVencimiento = retiro.plusDays(14);
        return fechaVencimiento;
    }
    public int diasDeAtraso(LocalDate corte){ // siempre >= 0
        int dias = ChronoUnit.DAYS.between(retiro, devolucion);
        return dias;
    }
    public int multa(LocalDate corte){ // 150 por dia, tope 3000
        
    }
}
