// Máximo de un arreglo. Escribí int maximo(int[] v) y testealo con JUnit (incluí el caso de un solo elemento).
public class MaximoArreglo {
    
    /**
     * maximo devuelve el número mas alto del arreglo.
     * @param v Arreglo tipo int[].
     * @return maximo int del arreglo, o -1 si el arreglo es null o está vacío.
     */
    public static int maximo(int[] v){
        if (v == null || v.length == 0){
            return -1;
        }
        int maximo = v[0];
        for (int i=1; i<v.length; i++){
            if (v[i]>maximo){
                maximo = v[i];
            }
        }

        return maximo;
    }

    public static void main(String[] args){
        int[] arr = {3, 2, 5, 6, 12, 2};
        int max = maximo(arr);
        System.out.println("El máximo del arreglo es " + max);
    }
}
