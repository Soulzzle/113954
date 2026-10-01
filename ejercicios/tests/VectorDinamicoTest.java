import guia5.dificil.VectorDinamico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorDinamicoTest {

    @Test
    void agregarYObtenerConservaElementosAlRedimensionar() {
        VectorDinamico<Integer> vector = new VectorDinamico<>();

        for (int i = 0; i < 20; i++) {
            vector.agregar(i);
        }

        assertEquals(20, vector.tamanio());
        for (int i = 0; i < 20; i++) {
            assertEquals(i, vector.obtener(i));
        }
    }

    @Test
    void insertarPermitePrincipioMedioYFinal() {
        VectorDinamico<String> vector = new VectorDinamico<>();
        vector.agregar("A");
        vector.agregar("C");

        vector.insertar(0, "inicio");
        vector.insertar(2, "medio");
        vector.insertar(vector.tamanio(), "final");

        assertEquals(5, vector.tamanio());
        assertEquals("inicio", vector.obtener(0));
        assertEquals("A", vector.obtener(1));
        assertEquals("medio", vector.obtener(2));
        assertEquals("C", vector.obtener(3));
        assertEquals("final", vector.obtener(4));
    }

    @Test
    void eliminarDevuelveElementoYDesplazaLosSiguientes() {
        VectorDinamico<Integer> vector = new VectorDinamico<>();
        vector.agregar(10);
        vector.agregar(20);
        vector.agregar(30);

        assertEquals(20, vector.eliminar(1));
        assertEquals(2, vector.tamanio());
        assertEquals(10, vector.obtener(0));
        assertEquals(30, vector.obtener(1));
        assertEquals(10, vector.eliminar(0));
        assertEquals(30, vector.eliminar(0));
        assertEquals(0, vector.tamanio());
    }

    @Test
    void operacionesPorIndiceRechazanIndicesInvalidos() {
        VectorDinamico<Integer> vector = new VectorDinamico<>();
        vector.agregar(1);

        assertThrows(IndexOutOfBoundsException.class, () -> vector.obtener(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.obtener(1));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.insertar(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.insertar(2, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.eliminar(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.eliminar(1));
    }
}
