package guia4.facil;

// Suma O(n). long sumar(int[] a); comentá que es 𝑂(𝑛).
public class Suma {
    public static long sumar(int[] a){
        long suma = 0; // O(1)
        for (int i = 0; i < a.length; i++){ // O(n)
            suma += a[i]; // O(1)
        }

        return suma; // O(1)
    }
} // T(n) = O(1) + O(n) + O(1) + O(1) = O(n)
