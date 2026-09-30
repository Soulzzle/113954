package guia5.medio;

import java.util.ArrayList;

// Pila sobre ArrayList. Pila<T> (apilar/desapilar/tope) usando ArrayList por dentro; test LIFO.
public class Pila<T> {
    private ArrayList<T> datos = new ArrayList<T>();

    public void apilar(T dato){
        datos.addLast(dato);
    }

    public T desapilar(){
        return datos.removeLast();
    }

    public T tope(){
        return datos.getLast();
    }
}
