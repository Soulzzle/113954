package guia4.medio;

// Búsqueda binaria O(log n). Sobre arreglo ordenado.
public class BusquedaBinaria {
    
    public static int buscar(int[] a, int objetivo) {
        return buscarRecursivo(a, objetivo, 0, a.length - 1);
    }

    private static int buscarRecursivo(int[] a, int objetivo, int inicio, int fin) {
        if (inicio > fin) {
            return -1; // Caso base: no encontrado
        }

        int medio = inicio + (fin - inicio) / 2;

        if (a[medio] == objetivo) {
            return medio; // Caso base: encontrado
        }
        
        if (a[medio] > objetivo) {
            return buscarRecursivo(a, objetivo, inicio, medio - 1);
        }
        
        return buscarRecursivo(a, objetivo, medio + 1, fin);
    }
}       // T(n) = T(n/2) + O(1)  ->  T(n/2) = T(n/4) + O(1)  ->  T(n/4) = T(n/8) + O(1)
        // T(n) = T(n/2^k) + kO(1)  ->  n/2^k = 1 ->  n = 2^k  ->  log(n) = k
