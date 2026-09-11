package tp1;

/**
 * ResultadoDeCarga guarda los resultados generados tras procesar el archivo.
 * @param registro el TDA poblado con todos los préstamos válidos instanciados.
 * @param errores el arreglo con los motivos por los que se descartaron líneas inválidas.
 * @param lineasDeDatos la cantidad de líneas de préstamos procesadas (excluyendo comentarios y líneas vacías).
 */
public record ResultadoDeCarga(RegistroDePrestamos registro, String[] errores, int lineasDeDatos) {
}