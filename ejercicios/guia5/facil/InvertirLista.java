package guia5.facil;
import java.util.List;
import java.util.LinkedList;

// Invertir. List<Integer> invertir(List<Integer> l) que devuelva una nueva lista invertida. Test
public class InvertirLista {
    
    public List<Integer> invertir(List<Integer> l){
        List<Integer> lista = new LinkedList<Integer>();

        for (Integer elem : l){
            lista.addFirst(elem);
        }

        return lista;
    }
}
