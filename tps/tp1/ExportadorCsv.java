package tp1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ExportadorCsv genera el reporte de multas en un formato de valores 
 * separados por punto y coma (csv).
 */
public class ExportadorCsv implements ExportadorDeReporte {

    // METODOS DE COMPORTAMIENTO
    /**
     * exportar procesa las filas y las escribe en el sistema de archivos.
     * @param filas el arreglo de datos consolidados por socio a exportar.
     * @param destino la ruta física donde se creará o sobrescribirá el archivo.
     * @throws IOException si ocurre un error de escritura en el disco.
     */
    @Override
    public void exportar(FilaDeSocio[] filas, Path destino) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        // arma los titulos de las columnas
        sb.append("padron;socio;prestamos;dias_atraso;multa;estado\n");
        
        // arma todas las filas
        for (int i = 0; i < filas.length; i++) {
            FilaDeSocio f = filas[i];
            sb.append(f.padron()).append(";")
              .append(f.socio()).append(";")
              .append(f.prestamos()).append(";")
              .append(f.diasDeAtraso()).append(";")
              .append(f.multa()).append(";")
              .append(f.estado()).append("\n");
        }
        
        Files.writeString(destino, sb.toString());
    }

    /**
     * extension indica el formato de archivo que produce este exportador.
     * @return la extensión del archivo "csv".
     */
    @Override
    public String extension() {
        return "csv";
    }
}