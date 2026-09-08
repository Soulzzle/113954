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
                () -> new Prestamo(null, 12345, "Ada Lovelace", "978-1", "Libro", null));
    }

    @Test
    void rechazaSocioNuloOVacio() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, null, "978-1", "Libro", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "   ", "978-1", "Libro", null));
    }

    @Test
    void rechazaIsbnNuloOVacio() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, "Ada Lovelace", null, "Libro", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "Ada Lovelace", " \t", "Libro", null));
    }

    @Test
    void rechazaTituloNuloOVacio() {
        assertThrows(NullPointerException.class,
                () -> new Prestamo(RETIRO, 12345, "Ada Lovelace", "978-1", null, null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 12345, "Ada Lovelace", "978-1", " \n", null));
    }

    @Test
    void rechazaPadronNoPositivo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, 0, "Ada Lovelace", "978-1", "Libro", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Prestamo(RETIRO, -1, "Ada Lovelace", "978-1", "Libro", null));
    }

    @Test
    void permiteDevolucionNulaYRechazaDevolucionAnteriorAlRetiro() {
        Prestamo pendiente = prestamo(null);

        assertTrue(pendiente.estaPendiente());
        assertThrows(IllegalArgumentException.class,
                () -> prestamo(RETIRO.minusDays(1)));
    }

    @Test
    void vencimientoEsCatorceDiasDespuesDelRetiro() {
        assertEquals(RETIRO.plusDays(14), prestamo(null).vencimiento());
    }

    @Test
    void permiteDevolucionEnLaFechaDeRetiro() {
        Prestamo prestamo = prestamo(RETIRO);

        assertFalse(prestamo.estaPendiente());
        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
    }

    @Test
    void prestamoDevueltoEnFechaNoTieneAtrasoNiMulta() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(14));

        assertFalse(prestamo.estaPendiente());
        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(30)));
    }

    @Test
    void atrasoComienzaAlDiaSiguienteDelVencimiento() {
        Prestamo prestamo = prestamo(null);

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(14)));
        assertEquals(1, prestamo.diasDeAtraso(RETIRO.plusDays(15)));
        assertEquals(150, prestamo.multa(RETIRO.plusDays(15)));
    }

    @Test
    void prestamoDevueltoAntesDelVencimientoNoTieneAtraso() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(7));

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(30)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(30)));
    }

    @Test
    void prestamoDevueltoConAtrasoCalculaDiasYMulta() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(17));

        assertEquals(3, prestamo.diasDeAtraso(RETIRO.plusDays(40)));
        assertEquals(450, prestamo.multa(RETIRO.plusDays(40)));
    }

    @Test
    void prestamoDevueltoCalculaAtrasoConLaDevolucionAunqueElCorteSeaAnterior() {
        Prestamo prestamo = prestamo(RETIRO.plusDays(17));

        assertEquals(3, prestamo.diasDeAtraso(RETIRO.plusDays(10)));
        assertEquals(450, prestamo.multa(RETIRO.plusDays(10)));
    }

    @Test
    void prestamoPendienteCalculaAtrasoHastaLaFechaDeCorte() {
        Prestamo prestamo = prestamo(null);

        assertEquals(6, prestamo.diasDeAtraso(RETIRO.plusDays(20)));
        assertEquals(900, prestamo.multa(RETIRO.plusDays(20)));
    }

    @Test
    void prestamoPendienteAntesDelVencimientoNoTieneAtraso() {
        Prestamo prestamo = prestamo(null);

        assertEquals(0, prestamo.diasDeAtraso(RETIRO.plusDays(10)));
        assertEquals(0, prestamo.multa(RETIRO.plusDays(10)));
    }

    @Test
    void multaTieneUnTopeDeTresMilPesos() {
        Prestamo prestamo = prestamo(null);

        assertEquals(3000, prestamo.multa(RETIRO.plusDays(34)));
        assertEquals(3000, prestamo.multa(RETIRO.plusDays(100)));
    }

    private Prestamo prestamo(LocalDate devolucion) {
        return new Prestamo(RETIRO, 12345, "Ada Lovelace", "978-1", "Libro", devolucion);
    }
}
