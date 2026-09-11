package tp1;

import java.io.IOException;
import java.nio.file.Path;

/**
 * ExportadorDeReporte define el contrato para generar los archivos de salida.
 * Permite intercambiar el formato del reporte sin que cambie la lógica principal del programa.
 */
public interface ExportadorDeReporte {

    // METODOS DE COMPORTAMIENTO
    /**
     * exportar procesa las filas y las escribe en el sistema de archivos.
     * @param filas el arreglo de datos consolidados por socio a exportar.
     * @param destino la ruta física donde se creará o sobrescribirá el archivo.
     * @throws IOException si ocurre un error de escritura en el disco.
     */
    void exportar(FilaDeSocio[] filas, Path destino) throws IOException;

    /**
     * extension indica el formato de archivo que produce este exportador.
     * @return la extensión del archivo (por ejemplo, "txt" o "csv").
     */
    String extension();   // "txt", "csv", ...
}
