package tp1;

import java.io.IOException;
import java.nio.file.Path;

public interface ExportadorDeReporte {
    void exportar(FilaDeSocio[] filas, Path destino) throws IOException;
    String extension();   // "txt", "csv", ...
}
