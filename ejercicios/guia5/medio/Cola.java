package guia5.medio;

import java.util.LinkedList;

// Cola sobre LinkedList. Cola<T> (encolar/desencolar/frente) usando LinkedList; test FIFO.
public class Cola<T> {
    private LinkedList<T> datos = new LinkedList<T>();

    public void encolar(T elem){
        datos.addLast(elem);
    }

    public T desencolar(){
        T dato = datos.removeFirst();
        return dato;
    }

    public T frente(){
        return datos.getFirst();
    }
}
