// Tabla de multiplicar. Con un for, imprimí la tabla del número que se pase por args.
class TablaMultiplicar {
    
    /**
     * imprimirTabla imprime por consola la tabla del número recibido.
     * @param n El número recibido.
     */
    public static void imprimirTabla(int n){
        System.out.println("La tabla de " + n + " es:");
        for(int i=1; i<=10; i++){
            int res = n*i;
            System.out.println(n + "x" + i + " = " + res);
        }
    }

    public static void main(String[] args){
        imprimirTabla(22);
    }
}
