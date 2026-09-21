import guia4.dificil.TorresDeHanoi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorresDeHanoiTest {

    @Test
    void devuelveCeroCuandoNoHayDiscos() {
        TorresDeHanoi hanoi = new TorresDeHanoi();

        assertEquals(0, hanoi.movimientos(0));
    }

    @Test
    void devuelveUnMovimientoConUnDisco() {
        TorresDeHanoi hanoi = new TorresDeHanoi();
        assertEquals(1, hanoi.movimientos(1));
    }

    @Test
    void devuelveLaCantidadCorrectaParaVariosDiscos() {
        TorresDeHanoi hanoi = new TorresDeHanoi();

        assertEquals(3, hanoi.movimientos(2));
        assertEquals(7, hanoi.movimientos(3));
        assertEquals(15, hanoi.movimientos(4));
        assertEquals(31, hanoi.movimientos(5));     // Todos los casos devuelven 2^n - 1
    }
}
