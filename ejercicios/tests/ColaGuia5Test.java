import guia5.medio.Cola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColaGuia5Test {

    @Test
    void encolarDesencolarRespetaOrdenFifo() {
        Cola<Integer> cola = new Cola<>();

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        assertEquals(10, cola.desencolar());
        assertEquals(20, cola.desencolar());
        assertEquals(30, cola.desencolar());
    }

    @Test
    void frenteDevuelveElPrimerElementoSinDesencolarlo() {
        Cola<String> cola = new Cola<>();
        cola.encolar("primero");
        cola.encolar("ultimo");

        assertEquals("primero", cola.frente());
        assertEquals("primero", cola.frente());
        assertEquals("primero", cola.desencolar());
    }
}
