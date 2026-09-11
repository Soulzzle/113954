package tp1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 * ExportadorTxt escribe el reporte de multas en el formato de texto solicitado.
 */
public class ExportadorTxt implements ExportadorDeReporte {

    // ATRIBUTOS
    private final LocalDate corte;
    private final String[] ranking;

    // CONSTRUCTORES
    /**
     * ExportadorTxt inicializa el exportador con los datos adicionales requeridos para el formato txt.
     * @param corte la fecha de corte utilizada para el cálculo de atrasos.
     * @param ranking el arreglo de cadenas ya formateadas con los títulos más pedidos.
     */
    public ExportadorTxt(LocalDate corte, String[] ranking) {
        this.corte = corte;
        this.ranking = ranking;
    }

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
        
        sb.append("BIBLIOTECA FIUBA - REPORTE DE MULTAS\n");
        sb.append("Fecha de corte: ").append(this.corte).append("\n\n");
        
        // arma los titulos de las columnas
        sb.append(String.format("%-7s %-20s %10s %11s %7s %s\n",
            "Padron", "Socio", "Prestamos", "DiasAtraso", "Multa", "Estado"));
        sb.append("--------------------------------------------------------------------\n");
            
        int totalPrestamos = 0;
        int totalAtraso = 0;
        int totalMulta = 0;
        
        // arma las filas de socios
        for (int i = 0; i < filas.length; i++) {
            FilaDeSocio f = filas[i];
            sb.append(String.format("%-7d %-20s %10d %11d %7d %s\n",
                f.padron(), f.socio(), f.prestamos(), f.diasDeAtraso(), f.multa(), f.estado()));
            
            totalPrestamos += f.prestamos();
            totalAtraso += f.diasDeAtraso();
            totalMulta += f.multa();
        }
        
        // separa las filas de socios de la fila de totales
        sb.append("--------------------------------------------------------------------\n");
        sb.append(String.format("%-29s %10d %11d %7d\n\n",
            "TOTALES", totalPrestamos, totalAtraso, totalMulta));
            
        // Ranking de libros
        sb.append("TITULOS MAS PEDIDOS\n");
        for (int i = 0; i < this.ranking.length; i++) {
            sb.append(this.ranking[i]).append("\n");
        }
        
        Files.writeString(destino, sb.toString());
    }

    /**
     * extension indica el formato de archivo que produce este exportador.
     * @return la extensión del archivo "txt".
     */
    @Override
    public String extension() {
        return "txt";
    }
}