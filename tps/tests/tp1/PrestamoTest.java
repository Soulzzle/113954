package tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PrestamoTest {

    private static final LocalDate RETIRO = LocalDate.of(2026, 9, 1);

    @Test
    void rechazaRetiroNulo() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(null, 12345, "Juan Perez", "978-1", "Algoritmos y programacion", null));
    }

    @Test
    void validaSocio() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, null, "978-1", "Algoritmos y programacion", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "   ", "978-1", "Algoritmos y programacion", null));
    }

    @Test
    void validaIsbn() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, "Juan Perez", null, "Algoritmos y programacion", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "Juan Perez", " \t", "Algoritmos y programacion", null));
    }

    @Test
    void validaTitulo() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, "Juan Perez", "978-1", null, null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "Juan Perez", "978-1", " \n", null));
    }

    @Test
    void validaPadron() {
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 0, "Juan Perez", "978-1", "Organizacion del computador", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, -1, "Juan Perez", "978-1", "Organizacion del computador", null));
    }

    @Test
    void rechazaDevolucionInvalida() {
        Prestamo pendiente = prestamo(null);

        assertTrue(pendiente.estaPendiente());
        assertThrows(IllegalArgumentException.class,
                () -> prestamo(RETIRO.minusDays(1)));
    }

    @Test
    void calculaVencimiento() {
        assertEquals(RETIRO.plusDays(14), prestamo(null).vencimiento());
    }

    @Test
    void aceptaDevolucionElDiaDelRetiro() {
        Prestamo prestamo = prestamo(RETIRO);

        assertFalse(prestamo.estaPendiente());
        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
    }

    @Test
    void prestamoEnFechaNoTieneMulta() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(14));

        assertFalse(prestamo.estaPendiente());
        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(30)));
    }

    @Test
    void calculaAtrasoDesdeVencimiento() {
        Prestamo prestamo = prestamo(null);

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(14)));
        assertEquals(1, prestamo.diasDeAtraso(RETIRO.plusDays(15)));
        assertEquals(150, prestamo.multa(RETIRO.plusDays(15)));
    }

    @Test
    void devolucionAnticipadaNoTieneAtraso() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(7));

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(30)));
    }

    @Test
    void calculaAtrasoYMulta() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(17));

        assertEquals(3, prestamo.diasDeAtraso(RETIRO.plusDays(40)));
        assertEquals(450, prestamo.multa(RETIRO.plusDays(40)));
    }

    @Test
    void usaDevolucionAunqueCorteSeaAnterior() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(17));

        assertEquals(3, prestamo.diasDeAtraso(RETIRO.plusDays(10)));
        assertEquals(450, prestamo.multa(RETIRO.plusDays(10)));
    }

    @Test
    void pendienteUsaFechaDeCorte() {
        Prestamo prestamo = prestamo(null);

        assertEquals(6, prestamo.diasDeAtraso(RETIRO.plusDays(20)));
        assertEquals(900, prestamo.multa(RETIRO.plusDays(20)));
    }

    @Test
    void pendienteSinAtraso() {
        Prestamo prestamo = prestamo(null);

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(10)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(10)));
    }

    @Test
    void limitaMulta() {
        Prestamo prestamo = prestamo(null);

        assertEquals(3000, prestamo.multa(RETIRO.plusDays(34)));
        assertEquals(3000, prestamo.multa(RETIRO.plusDays(100)));
    }

    private Prestamo prestamo(LocalDate devolucion) {
        return new Prestamo(RETIRO, 12345, "Juan Perez", "978-1", "Algoritmos y programacion", devolucion);
    }
}
