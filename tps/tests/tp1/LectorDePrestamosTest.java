package tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class LectorDePrestamosTest {

    @Test
    void procesaArchivo() throws IOException {
        Path archivoPrueba = Paths.get("tps","tp1", "datos", "prestamos.csv");
        
        ResultadoDeCarga resultado = LectorDePrestamos.cargar(archivoPrueba);

        assertEquals(22, resultado.lineasDeDatos(), "Deben ser 22 líneas procesadas");
        assertEquals(18, resultado.registro().cantidad(), "Deben quedar 18 préstamos válidos");
        assertEquals(4, resultado.errores().length, "Deben guardarse 4 errores");

        String[] errores = resultado.errores();
        assertTrue(errores[0].contains("linea 28"), "Falla en línea 28");
        assertTrue(errores[1].contains("linea 29"), "Falla en línea 29");
        assertTrue(errores[2].contains("linea 30"), "Falla en línea 30");
        assertTrue(errores[3].contains("linea 31"), "Falla en línea 31");
    }
}