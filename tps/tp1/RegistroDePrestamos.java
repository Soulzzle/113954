package tp1;

/**
 * RegistroDePrestamos define las operaciones disponibles para administrar
 * los préstamos de la biblioteca.
 */
public interface RegistroDePrestamos {

    /**
     * registrar incorpora un nuevo préstamo al registro.
     * @param p el préstamo a registrar.
     * @throws NullPointerException si el préstamo es nulo.
     */
    void registrar(Prestamo p);

    /**
     * cantidad indica cuántos préstamos fueron registrados.
     * @return la cantidad de préstamos del registro.
     */
    int cantidad();

    /**
     * obtener devuelve el préstamo ubicado en una posición determinada.
     * @param i el índice del préstamo a obtener.
     * @return el préstamo ubicado en la posición indicada.
     * @throws IndexOutOfBoundsException si el índice está fuera del rango lógico del registro.
     */
    Prestamo obtener(int i);

    /**
     * padrones junta los números de los socios que tienen préstamos registrados.
     * @return un arreglo sin padrones repetidos y en orden de aparición.
     */
    int[] padrones();

    /**
     * prestamosDe filtra los préstamos correspondientes a un padrón específico.
     * @param padron el número de padrón a buscar.
     * @return un arreglo con los préstamos del padrón, o vacío si no hay ninguno.
     */
    Prestamo[] prestamosDe(int padron);

    /**
     * titulosMasPedidos arma un ranking con los títulos más solicitados.
     * Los títulos se ordenan por cantidad de pedidos y, en caso de empate,
     * alfabéticamente.
     * @param n la cantidad máxima de títulos a devolver.
     * @return un arreglo con los títulos más pedidos.
     */
    String[] titulosMasPedidos(int n);
}
