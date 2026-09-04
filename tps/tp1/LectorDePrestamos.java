package tp1;

import java.io.IOException;

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
