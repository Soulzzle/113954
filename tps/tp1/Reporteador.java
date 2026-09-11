package tp1;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Reporteador se encarga de procesar los datos del registro y 
 * darles el formato necesario para generar los reportes de salida.
 */
public class Reporteador {

    // METODOS DE COMPORTAMIENTO
    /**
     * porSocio agrupa todos los préstamos de la biblioteca por padrón, calcula 
     * las multas totales y el estado de cada socio, y ordena el resultado final.
     * @param r el registro de préstamos poblado con los datos.
     * @param corte la fecha utilizada para calcular los días de atraso de los préstamos pendientes.
     * @return un arreglo de FilaDeSocio ordenado por multa descendente y desempate alfabético.
     */
    public static FilaDeSocio[] porSocio(RegistroDePrestamos r, LocalDate corte) {
        int[] padrones = r.padrones();
        FilaDeSocio[] filas = new FilaDeSocio[padrones.length];

        for (int i = 0; i < padrones.length; i++) {
            Prestamo[] prestamos = r.prestamosDe(padrones[i]);
            
            String socio = prestamos[0].socio();
            int cantPrestamos = prestamos.length;
            int atrasoTotal = 0;
            int multaTotal = 0;

            for (int j = 0; j < cantPrestamos; j++) {
                atrasoTotal += prestamos[j].diasDeAtraso(corte);
                multaTotal += prestamos[j].multa(corte);
            }

            String estado;
            if (multaTotal > 0){
                estado = "CON_DEUDA";
            } else{
                estado = "AL_DIA";
            }
            filas[i] = new FilaDeSocio(padrones[i], socio, cantPrestamos, atrasoTotal, multaTotal, estado);
        }

        // Usa el compareTo definido en FilaDeSocio.java para organizarlo.
        Arrays.sort(filas);
        return filas;
    }

    /**
     * ranking genera las líneas de texto formateadas para el reporte de títulos más pedidos.
     * @param r el registro de préstamos poblado con los datos.
     * @param n la cantidad máxima de posiciones a mostrar en el ranking.
     * @return un arreglo de strings donde cada elemento es una línea del reporte formateada.
     */
    public static String[] ranking(RegistroDePrestamos r, int n) {
        String[] titulos = r.titulosMasPedidos(n);
        String[] reporte = new String[titulos.length];

        for (int i = 0; i < titulos.length; i++) {
            int cantidadPedida = 0;
            
            // cuenta las veces que aparece el titulo en el registro entero.
            for (int j = 0; j < r.cantidad(); j++) {
                if (r.obtener(j).titulo().equals(titulos[i])) {
                    cantidadPedida++;
                }
            }
            
            // pone el formato pedido específico
            reporte[i] = String.format("%2d. %s %d", i + 1, titulos[i], cantidadPedida);
        }

        return reporte;
    }
}
