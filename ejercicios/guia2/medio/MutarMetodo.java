package guia2.medio;

// Mutar en un método. Método que duplique cada elemento de un int[] recibido (in place);
// test que el arreglo de afuera quedó duplicado.
public class MutarMetodo {
    public static void duplicarVector(int[] v){
        for(int i=0; i<v.length; i++){
            v[i] = v[i]*2;
        }
    }
}
