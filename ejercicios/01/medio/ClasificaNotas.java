// Clasifica una nota entera en: "insuficiente", "aprobado" o "distinguido".
// Usa switch expression y lanza una excepción propia si la nota está fuera de 0–10.
public class ClasificaNotas {

    /**
     * Devuelve la categoría de la nota recibida.
     *
     * @param nota valor entero entre 0 y 10 inclusive.
     * @return "insuficiente", "aprobado" o "distinguido".
     * @throws NotaInvalidaException si la nota no está en el rango [0, 10].
     */
    public static String clasificar(int nota){
        if (nota<0 || nota>10) {
            throw new NotaInvalidaException("Nota fuera de rango [0-10]."); 
        }

        String resultado = switch(nota){
            case 0, 1, 2, 3 -> "insuficiente";
            case 4, 5, 6, 7 -> "aprobado";
            default -> "distinguido";
        };

        return resultado;
    }

    public static void main(String[] args){
        int n = 7;
        System.out.println(clasificar(n));
    }
}

class NotaInvalidaException extends RuntimeException {
    public NotaInvalidaException(String mensaje){
        super(mensaje);
    }
}