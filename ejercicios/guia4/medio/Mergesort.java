package guia4.medio;

// Mergesort O(n log n). Con su recurrencia comentada
public class Mergesort {

    /*
     * Recurrencia: T(n) = 2T(n/2) + O(n)
     * 
     * Demostración con Teorema Maestro:
     * La ecuación responde a la forma general T(n) = aT(n/b) + O(n^c)
     * 
     * - a = 2 : El problema se divide en 2 llamadas recursivas (las dos mitades).
     * - b = 2 : El tamaño de cada subproblema es la mitad del original (n/2).
     * - c = 1 : El trabajo adicional fuera de la recursión (el método merge) recorre 
     *           los elementos para intercalarlos, lo que toma tiempo lineal O(n).
     * 
     * Aplicando el teorema, comparamos c con log_b(a):
     * log_2(2) = 1
     * 
     * Como log_2(2) es igual a c (1 == 1), caemos en el caso del teorema cuya 
     * solución directa es T(n) = O(n^c * log n).
     * 
     * Sustituyendo c = 1, la complejidad final es O(n log n).
     */
    public static void ordenar(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        // Se crea un arreglo auxiliar una sola vez para evitar instanciar arreglos
        // repetidamente en cada llamada recursiva, lo cual empeoraría el rendimiento.
        int[] auxiliar = new int[a.length];
        ordenarRecursivo(a, auxiliar, 0, a.length - 1);
    }

    private static void ordenarRecursivo(int[] a, int[] aux, int inicio, int fin) {
        if (inicio >= fin) {
            return; // Caso base: subarreglo de tamaño 1 o 0
        }

        int medio = inicio + (fin - inicio) / 2;

        ordenarRecursivo(a, aux, inicio, medio);
        ordenarRecursivo(a, aux, medio + 1, fin);

        merge(a, aux, inicio, medio, fin);
    }

    private static void merge(int[] a, int[] aux, int inicio, int medio, int fin) {
        // Copiar los elementos al arreglo auxiliar
        for (int k = inicio; k <= fin; k++) {
            aux[k] = a[k];
        }

        int i = inicio;      // Puntero para la mitad izquierda
        int j = medio + 1;   // Puntero para la mitad derecha

        // Intercalar las dos mitades ordenadas de vuelta al arreglo original
        for (int k = inicio; k <= fin; k++) {
            if (i > medio) {
                // Se agotó la mitad izquierda, tomar de la derecha
                a[k] = aux[j++];
            } else if (j > fin) {
                // Se agotó la mitad derecha, tomar de la izquierda
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                // El elemento derecho es menor, tomar de la derecha
                a[k] = aux[j++];
            } else {
                // El elemento izquierdo es menor o igual, tomar de la izquierda
                a[k] = aux[i++];
            }
        }
    }
}

