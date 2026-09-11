package tp1;

import java.io.IOException;

// Lee el archivo con Files.readAllLines, ignora blancos y comentarios, arma un Prestamo por cada línea
// válida,  y  por  cada  línea  inválida  guarda  un  mensaje  con  el  número  de  línea  real  del  archivo  (contando
// comentarios y blancos).
public class LineaInvalidaException extends RuntimeException {
    public LineaInvalidaException(int numeroDeLinea, String motivo) {

    }
    public int numeroDeLinea() {
        
    }
}
public record ResultadoDeCarga(RegistroDePrestamos registro, String[] errores, int lineasDeDatos) {

}
public class LectorDePrestamos {
    public static ResultadoDeCarga cargar(Path archivo) throws IOException {

    }
} 
