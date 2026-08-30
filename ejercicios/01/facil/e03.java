import java.util.Scanner;

// Par o impar. Dado un entero, indicá si es par o impar usando el operador %.
class ParOImpar {
    /**
     * esPar evalua si el resto de la división del número es igual a 0.
     * @param n número a evaluar.
     * @return true si es par, false si es impar.
     */
    public static boolean esPar(int n){
        return n % 2 == 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresá un número: ");
        var n = scanner.nextInt();
        if (esPar(n)){
            System.out.println("El número " + n + " es par.");
        } else{
            System.out.println("El número " + n + " es impar.");
        }
    }
}
