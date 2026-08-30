// Promedio de un arreglo. Dado un double[], calculá el promedio con un for-each.
class PromedioArreglo {
    
    /**
     * promedioArreglo recibe un arreglo de doubles y devuelve el promedio.
     * @param arr Arreglo de doubles.
     * @return promedio total de los elementos del arreglo.
     */
    public static double promedioArreglo(double[] arr){
        double promedio = 0;
        int contador = 0;
        for(double elem : arr){
            promedio += elem;
            contador++;
        }
        promedio = promedio / contador;
        return promedio;
    }

    public static void main(String[] args){
        double[] arr = {3.5, 2.3, 8.6};
        double promedio = promedioArreglo(arr);
        System.out.println("El promedio del arreglo es: " + promedio);
    }
}
