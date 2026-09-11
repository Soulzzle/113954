package tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

class ExportadorCsvTest {

    @Test
    void exportaCsv() throws IOException {
        FilaDeSocio[] filas = {
            new FilaDeSocio(39876, "Jaime Gómez", 4, 24, 3600, "CON_DEUDA"),
            new FilaDeSocio(42001, "Carlos Peralta", 4, 0, 0, "AL_DIA")
        };
        
        ExportadorCsv exportador = new ExportadorCsv();
        
        Path archivoTemporal = Files.createTempFile("reporte_test", ".csv");
        
        exportador.exportar(filas, archivoTemporal);
        
        List<String> lineas = Files.readAllLines(archivoTemporal);
        
        assertEquals(3, lineas.size(), "Debe haber 3 líneas: el encabezado y las 2 filas de datos");
        
        assertEquals("padron;socio;prestamos;dias_atraso;multa;estado", lineas.get(0));
        assertEquals("39876;Jaime Gómez;4;24;3600;CON_DEUDA", lineas.get(1));
        assertEquals("42001;Carlos Peralta;4;0;0;AL_DIA", lineas.get(2));
        
        Files.deleteIfExists(archivoTemporal);
    }
}