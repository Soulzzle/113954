import guia3.medio.Pila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PilaTest {
    @Test
    void verificaComportamientoLifo() {
        Pila<Integer> pila = new Pila<>(2);

        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        assertEquals(3, pila.tamanio());
        assertFalse(pila.estaVacia());
        assertEquals(30, pila.tope());
        assertEquals(30, pila.desapilar());
        assertEquals(20, pila.tope());
        assertEquals(20, pila.desapilar());
        assertEquals(10, pila.tope());
        assertEquals(10, pila.desapilar());
        assertTrue(pila.estaVacia());
        assertEquals(0, pila.tamanio());
    }
}
