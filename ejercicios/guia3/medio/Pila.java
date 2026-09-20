package guia3.medio;

import java.util.Arrays;
import java.util.EmptyStackException;

// TDA Pila. Sobre arreglo: apilar, desapilar, tope, estaVacia, tamanio; test del comportamiento LIFO.
public class Pila<T> {
    // ATRIBUTOS
    private T[] elementos;
    private int cantidad;

    // CONSTRUCTORES
    @SuppressWarnings("unchecked") // Suprime la advertencia del compilador por el casteo
    public Pila(int capacidad){
        this.elementos = (T[]) new Object[capacidad];
        this.cantidad = 0;
    }

    // METODOS DE COMPORTAMIENTO
    public void apilar(T dato){
        if (this.cantidad == this.elementos.length){
            int nuevaCapacidad = this.elementos.length == 0 ? 8 : this.cantidad * 2;
            this.elementos = Arrays.copyOf(elementos, nuevaCapacidad);
        }

        this.elementos[this.cantidad] = dato;
        this.cantidad++;
    }

    public T desapilar(){
        if (this.cantidad == 0){
            throw new EmptyStackException();
        }

        this.cantidad--;
        T dato = this.elementos[this.cantidad];
        this.elementos[this.cantidad] = null;
        return dato;
    }

    public T tope(){
        if (this.cantidad == 0){
            throw new EmptyStackException();
        }

        return this.elementos[this.cantidad - 1];
    }

    public boolean estaVacia(){
        return this.cantidad == 0;
    }

    public int tamanio(){
        return this.cantidad;
    }
}
