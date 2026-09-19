import guia3.facil.PuntoEncapsulado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PuntoEncapsuladoTest {
    @Test
    void verificaDatosYModuloDelPunto() {
        PuntoEncapsulado punto = new PuntoEncapsulado(3, 4);

        assertEquals(3, punto.getX());
        assertEquals(4, punto.getY());
        assertEquals(5, punto.modulo());
    }
}
