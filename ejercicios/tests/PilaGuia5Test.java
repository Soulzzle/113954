import guia5.medio.Pila;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilaGuia5Test {

    @Test
    void apilarDesapilarRespetaOrdenLifo() {
        Pila<Integer> pila = new Pila<>();

        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        assertEquals(30, pila.desapilar());
        assertEquals(20, pila.desapilar());
        assertEquals(10, pila.desapilar());
    }

    @Test
    void topeDevuelveElUltimoSinDesapilarlo() {
        Pila<String> pila = new Pila<>();
        pila.apilar("primero");
        pila.apilar("ultimo");

        assertEquals("ultimo", pila.tope());
        assertEquals("ultimo", pila.tope());
        assertEquals("ultimo", pila.desapilar());
    }
}