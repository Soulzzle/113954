package tp1;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public record FilaDeSocio(int padron, String socio, int prestamos, int diasDeAtraso, int multa, String estado) {

}
public class Reporteador {
    public static FilaDeSocio[] porSocio(RegistroDePrestamos r, LocalDate corte) {

    }
    public static String[] ranking(RegistroDePrestamos r, int n) {
        
    }
}
public interface ExportadorDeReporte {
    void exportar(FilaDeSocio[] filas, Path destino) throws IOException;
    String extension();   // "txt", "csv", ...
}
