package tp1;

import java.time.LocalDate;

public record Prestamo(LocalDate retiro, int padron, String socio, String isbn, String titulo, LocalDate devolucion) {
    // Valida en el constructor compacto: un Prestamo mal formado NO debe existir.
    //  - socio, isbn y titulo no pueden ser null ni vacios
    //  - padron debe ser positivo
    //  - devolucion puede ser null (pendiente), pero si no lo es,
    //    no puede ser anterior a retiro
    public boolean estaPendiente() {
        return false;
    }
    public LocalDate vencimiento() { // retiro + 14 dias
        return LocalDate.now();
    }
    public int diasDeAtraso(LocalDate corte) { // siempre >= 0
        return 0;
    }
    public int multa(LocalDate corte) { // 150 por dia, tope 3000
        return 0;
    }
}
