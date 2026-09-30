package guia5.facil;

import java.util.LinkedHashSet;
import java.util.Set;

// Intersección. Intersección de dos Set<Integer> (usá retainAll sobre una copia).
public class Interseccion {
    
    public static Set<Integer> interseccionDeSets(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> setInterseccion = new LinkedHashSet<Integer>();
        setInterseccion.addAll(s1);
        setInterseccion.retainAll(s2);

        return setInterseccion;
    }
}
