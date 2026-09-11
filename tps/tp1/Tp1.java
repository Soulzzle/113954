package tp1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Tp1 es el punto de entrada principal. lee el archivo, 
 * imprime el resumen de carga por consola y genera los reportes en disco.
 */
public class Tp1 {

    // ATRIBUTOS
    private static final String ENTRADA_POR_DEFECTO = "datos/prestamos.csv";
    private static final LocalDate CORTE_POR_DEFECTO = LocalDate.parse("2026-05-04");

    // METODOS DE COMPORTAMIENTO
    /**
     * Ejecuta la carga del archivo y genera los reportes de texto y CSV.
     * @param args archivo de entrada y fecha de corte, ambos opcionales.
     * @throws IOException si no se puede leer el archivo o escribir un reporte.
     */
    public static void main(String[] args) throws IOException {
        String rutaEntrada = ENTRADA_POR_DEFECTO;
        LocalDate fechaCorte = CORTE_POR_DEFECTO;

        if (args.length == 1) {
            rutaEntrada = args[0];
        } else if (args.length >= 2) {
            rutaEntrada = args[0];
            fechaCorte = LocalDate.parse(args[1]);
        }

        // carga los datos del archivo de entrada.
        ResultadoDeCarga resultado = LectorDePrestamos.cargar(Paths.get(rutaEntrada));
        RegistroDePrestamos registro = resultado.registro();

        // imprime el resumen por consola
        imprimirResumen(resultado);

        // genera las filas y devuelve el ranking de 3 titulos más pedidos.
        FilaDeSocio[] filas = Reporteador.porSocio(registro, fechaCorte);
        String[] ranking = Reporteador.ranking(registro, 3); 

        // crea los exportadores para cada formato de salida.
        ExportadorDeReporte txt = new ExportadorTxt(fechaCorte, ranking);
        ExportadorDeReporte csv = new ExportadorCsv();

        // escribe los reportes en disco
        escribirReporte(txt, filas, Paths.get("reporte.txt"));
        escribirReporte(csv, filas, Paths.get("reporte.csv"));
    }

    /**
        * imprimirResumen muestra cuántas líneas se leyeron y cuáles dieron error.
        * @param res resultado de leer el archivo de préstamos.
     */
    private static void imprimirResumen(ResultadoDeCarga res) {
        int descartadas = res.errores().length;
        int validas = res.lineasDeDatos() - descartadas;

        System.out.println(String.format("Lineas de datos: %d | validas: %d | descartadas: %d",
            res.lineasDeDatos(), validas, descartadas));

        for (int i = 0; i < res.errores().length; i++) {
            System.out.println(res.errores()[i]);
        }
    }

    /**
        * escribirReporte guarda el reporte en el archivo indicado.
        * @param exportador exportador que se va a usar.
        * @param filas datos que se van a escribir.
        * @param destino archivo donde se guarda el reporte.
        * @throws IOException si ocurre un error al guardar el archivo.
     */
    private static void escribirReporte(ExportadorDeReporte exportador, FilaDeSocio[] filas, Path destino) throws IOException {
        exportador.exportar(filas, destino);
    }
}