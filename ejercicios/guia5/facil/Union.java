package guia5.facil;

import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashSet;

// Unión. Unión de dos listas sin duplicados.
public class Union {
    
    public static List<Integer> union(List<Integer> l1, List<Integer> l2){
        List<Integer> listaUnida = new LinkedList<Integer>();
        LinkedHashSet<Integer> union = new LinkedHashSet<Integer>();
        union.addAll(l1);
        union.addAll(l2);
        listaUnida.addAll(union);

        return listaUnida;
    }
}
