package tp1;

public interface ExportadorDeReporte {
    void exportar(FilaDeSocio[] filas, Path destino) throws IOException;
    String extension();   // "txt", "csv", ...
}
