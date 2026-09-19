import guia2.medio.MutarMetodo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MutarMetodoTest {
    @Test
    void verificaQueArregloEsDuplicado() {
        int[] v = {1, 2, 3, 4, 5};

        MutarMetodo.duplicarVector(v);

        assertArrayEquals(new int[] {2, 4, 6, 8, 10}, v,"El arreglo original debe quedar duplicado en su lugar");
    }
}
