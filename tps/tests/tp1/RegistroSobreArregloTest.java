package tp1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class RegistroSobreArregloTest {

    private static final LocalDate HOY = LocalDate.of(2026, 9, 1);

    @Test
    void registrarRechazaPrestamoNulo() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        assertThrows(NullPointerException.class, () -> registro.registrar(null));
    }

    @Test
    void registrarSuperaCapacidadInicialSinPerderDatos() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        
        for (int i = 0; i < 10; i++) {
            registro.registrar(crearPrestamo(100 + i, "Libro " + i));
        }
        
        assertEquals(10, registro.cantidad());
        assertEquals("Libro 9", registro.obtener(9).titulo());
    }

    @Test
    void obtenerLanzaExcepcionSiIndiceEstaFueraDeRango() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        registro.registrar(crearPrestamo(113954, "Algoritmos y Estructuras de Datos"));

        assertThrows(IndexOutOfBoundsException.class, () -> registro.obtener(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> registro.obtener(1));
        assertEquals("Algoritmos y Estructuras de Datos", registro.obtener(0).titulo());
    }

    @Test
    void padronesDevuelveListaUnicaEnOrdenDeAparicion() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        registro.registrar(crearPrestamo(105, "Organizacion del Computador"));
        registro.registrar(crearPrestamo(102, "Probabilidad y Estadistica B"));
        registro.registrar(crearPrestamo(105, "Algoritmos y Estructuras de Datos"));
        registro.registrar(crearPrestamo(108, "Libro random"));

        int[] esperados = {105, 102, 108};
        assertArrayEquals(esperados, registro.padrones());
    }

    @Test
    void prestamosDeFiltraCorrectamentePorPadron() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        registro.registrar(crearPrestamo(105, "Organizacion del Computador"));
        registro.registrar(crearPrestamo(102, "Probabilidad y Estadistica B"));
        registro.registrar(crearPrestamo(105, "Algoritmos y Estructuras de Datos"));

        Prestamo[] del105 = registro.prestamosDe(105);
        assertEquals(2, del105.length);
        assertEquals("Organizacion del Computador", del105[0].titulo());
        assertEquals("Algoritmos y Estructuras de Datos", del105[1].titulo());

        Prestamo[] inexistente = registro.prestamosDe(999);
        assertEquals(0, inexistente.length);
    }

    @Test
    void titulosMasPedidosOrdenaPorFrecuenciaYDesempataAlfabeticamente() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        
        // 3 pedidos de Probabilidad
        registro.registrar(crearPrestamo(1, "Probabilidad y Estadistica B"));
        registro.registrar(crearPrestamo(2, "Probabilidad y Estadistica B"));
        registro.registrar(crearPrestamo(3, "Probabilidad y Estadistica B"));
        
        // 2 pedidos de Algoritmos
        registro.registrar(crearPrestamo(1, "Algoritmos y Estructuras de Datos"));
        registro.registrar(crearPrestamo(2, "Algoritmos y Estructuras de Datos"));
        
        // 2 pedidos de Organizacion (Empata en cantidad con Algoritmos)
        registro.registrar(crearPrestamo(3, "Organizacion del Computador"));
        registro.registrar(crearPrestamo(4, "Organizacion del Computador"));

        // 1 pedido de Libro random
        registro.registrar(crearPrestamo(5, "Libro random"));

        String[] top3 = registro.titulosMasPedidos(3);
        
        assertEquals(3, top3.length);
        assertEquals("Probabilidad y Estadistica B", top3[0]);
        // Algoritmos gana el desempate contra Organización por orden alfabético
        assertEquals("Algoritmos y Estructuras de Datos", top3[1]); 
        assertEquals("Organizacion del Computador", top3[2]);
    }
    
    @Test
    void titulosMasPedidosSeAdaptaSiSePidenMasTitulosDeLosQueExisten() {
        RegistroSobreArreglo registro = new RegistroSobreArreglo();
        registro.registrar(crearPrestamo(1, "Libro random"));
        registro.registrar(crearPrestamo(2, "Libro random"));
        
        String[] ranking = registro.titulosMasPedidos(10);
        assertEquals(1, ranking.length);
        assertEquals("Libro random", ranking[0]);
    }

    private Prestamo crearPrestamo(int padron, String titulo) {
        return new Prestamo(HOY, padron, "Socio " + padron, "ISBN-" + titulo.length(), titulo, null);
    }
}
