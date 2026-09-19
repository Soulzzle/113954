// Swap que no anda. Mostrá que un swap(int a, int b) no intercambia nada afuera, y escribí
// swap(int[] v, int i, int j) que sí lo haga. Testealo.
public class SwapQueNoAnda {
    
    private SwapQueNoAnda(){}

    public static void swapNoAnda(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static void swapSiAnda(int[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
