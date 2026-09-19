import guia2.medio.SwapQueNoAnda;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SwapQueNoAndaTest {

    @Test
    void swapNoAndaNoCambiaLosValoresOriginales() {
        int a = 10;
        int b = 20;

        SwapQueNoAnda.swapNoAnda(a, b);

        assertEquals(10, a, "El valor de 'a' no debe cambiar porque se pasa por valor");
        assertEquals(20, b, "El valor de 'b' no debe cambiar porque se pasa por valor");
    }

    @Test
    void swapSiAndaIntercambiaLosValoresDelArreglo() {
        int[] v = {1, 2, 3, 4};

        SwapQueNoAnda.swapSiAnda(v, 1, 3);

        assertArrayEquals(new int[] {1, 4, 3, 2}, v,"El arreglo original debe quedar modificado con los elementos intercambiados");
    }
}
