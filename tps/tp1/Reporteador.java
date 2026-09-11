package tp1;

import java.time.LocalDate;
import java.util.Arrays;

public class Reporteador {

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
            reporte[i] = String.format("%d. %-35s %d", i+1, titulos[i], cantidadPedida);
        }

        return reporte;
    }
}
