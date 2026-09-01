import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximoArregloTest {

    @Test
    void devuelveElMayorElementoDelArreglo() {
        int[] arreglo = {3, 2, 5, 6, 12, 2};

        assertEquals(12, MaximoArreglo.maximo(arreglo));
    }

    @Test
    void devuelveElUnicoElementoCuandoHayUnSoloElemento() {
        int[] arreglo = {42};

        assertEquals(42, MaximoArreglo.maximo(arreglo));
    }

    @Test
    void devuelveMenosUnoSiElArregloEsVacio() {
        assertEquals(-1, MaximoArreglo.maximo(new int[0]));
    }

    @Test
    void devuelveMenosUnoSiElArregloEsNull() {
        assertEquals(-1, MaximoArreglo.maximo(null));
    }
}
