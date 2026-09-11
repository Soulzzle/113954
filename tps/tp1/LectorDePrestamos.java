package tp1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * LectorDePrestamos se encarga de leer el archivo físico en disco, 
 * extraer sus datos y transformarlos en objetos del modelo de dominio.
 */
public class LectorDePrestamos {

    //METODOS DE COMPORTAMIENTO
    /**
     * cargar lee el archivo completo, procesa cada línea aplicando las validaciones 
     * de negocio, y aísla los errores sin interrumpir la lectura general.
     * @param archivo la ruta física al archivo de texto a procesar.
     * @return un ResultadoDeCarga con los préstamos válidos, los errores encontrados y las estadísticas.
     * @throws IOException si ocurre un error de lectura al intentar acceder al archivo en el disco.
     */
    public static ResultadoDeCarga cargar(Path archivo) throws IOException {
        List<String> lineas = Files.readAllLines(archivo);
        RegistroDePrestamos registro = new RegistroSobreArreglo();
        
        String[] errores = new String[8];
        int topeErrores = 0;
        int lineasDeDatos = 0;

        for (int i = 0; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            int numLineaReal = i + 1; 

            // todas las lineas en blanco o que arrancan con # se ignoran.
            if (linea.isBlank() || linea.startsWith("#")) {
                continue;
            }

            lineasDeDatos++;

            try {
                // El -1 es para no perder espacios vacíos al final de la línea.
                String[] campos = linea.split(";", -1);
                
                if (campos.length != 6) {
                    throw new LineaInvalidaException(numLineaReal, "se esperaban 6 campos y llegaron " + campos.length);
                }

                LocalDate retiro;
                try {
                    retiro = LocalDate.parse(campos[0].trim());
                } catch (DateTimeParseException e) {
                    throw new LineaInvalidaException(numLineaReal, "fecha invalida: " + campos[0]);
                }

                int padron;
                try {
                    padron = Integer.parseInt(campos[1].trim());
                } catch (NumberFormatException e) {
                    throw new LineaInvalidaException(numLineaReal, "padron no numerico: " + campos[1]);
                }

                String socio = campos[2].trim();
                String isbn = campos[3].trim();
                String titulo = campos[4].trim();

                LocalDate devolucion = null;
                if (!campos[5].trim().isEmpty()) {
                    try {
                        devolucion = LocalDate.parse(campos[5].trim());
                    } catch (DateTimeParseException e) {
                        throw new LineaInvalidaException(numLineaReal, "fecha de devolucion invalida: " + campos[5]);
                    }
                }

                try {
                    Prestamo p = new Prestamo(retiro, padron, socio, isbn, titulo, devolucion);
                    registro.registrar(p);
                } catch (IllegalArgumentException | NullPointerException e) {
                    throw new LineaInvalidaException(numLineaReal, e.getMessage());
                }

            } catch (LineaInvalidaException e) {
                // Redimensiona el arreglo de errores a mano si se llena
                if (topeErrores == errores.length) {
                    errores = Arrays.copyOf(errores, errores.length * 2);
                }
                errores[topeErrores] = "linea " + e.numeroDeLinea() + ": " + e.getMessage();
                topeErrores++;
            }
        }

        errores = Arrays.copyOf(errores, topeErrores);
        // devuelve los 3 resultados en un nuevo ResultadoDeCarga.
        return new ResultadoDeCarga(registro, errores, lineasDeDatos);
    }
}
