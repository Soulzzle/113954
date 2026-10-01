package guia5.medio;

import java.util.ArrayList;
import java.util.List;

// Eliminar según condición. Quitá de una List los múltiplos de 3 (removeIf). Test.
public class EliminarMultiplosDe3 {
    
    public List<Integer> eliminaMultiplosDe3(List<Integer> l){
        List<Integer> nuevaLista = new ArrayList<Integer>();
        nuevaLista.addAll(l);
        nuevaLista.removeIf(elem -> elem % 3 == 0);

        return nuevaLista;
    }
}
