package guia5.facil;

import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashSet;

// Sin duplicados. List<Integer> sinDuplicados(List<Integer> l) preservando el orden (usá LinkedHashSet)
public class SinDuplicados {
    
    public static List<Integer> sinDuplicados(List<Integer> l){
        List<Integer> lista = new LinkedList<Integer>();
        LinkedHashSet<Integer> listaSinDuplicados = new LinkedHashSet<Integer>();
        for (Integer elem : l){
            listaSinDuplicados.add(elem);
        }
        lista.addAll(listaSinDuplicados);
        return lista;
    }
}
