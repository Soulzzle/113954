
// Mayor de dos. Escribí un método int mayor(int a, int b) que devuelva el mayor.
class MayorDeDos {
    static final int IGUALES = -1;
    
    /**
     * mayor compara y devuelve el número mayor recibido por parámetro.
     * @param a Primer número int recibido.
     * @param b Segundo número int recibido.
     * @return Devuelve a si a>b, b si a<b, o -1 si son iguales.
     */
    public static int mayor(int a, int b){
        if(a > b){
            return a;
        } else if(a < b){
            return b;
        } else{
            return IGUALES;
        }
    }

    public static void main(String[] args){
        int mayorNum = mayor(2,3);
        if(mayorNum == IGUALES){
            System.out.println("Ambos números son iguales.");
        } else{
            System.out.println("El número mayor es " + mayorNum);
        }
    }
}
