package guia5.dificil;

import java.util.Arrays;

// Vectordinámico. VectorDinamico<T> sobrearregloconredimensión(agregar/obtener/insertar/eliminar/tamanio);
// test que crece más allá de la capacidad inicial.
public class VectorDinamico<T> {
    // ATRIBUTOS
    private final int CAPACIDAD_INICIAL = 8;
    
    private T[] datos;
    private int cantDatos;

    // CONSTRUCTORES
    @SuppressWarnings("unchecked")
    public VectorDinamico(){
        this.datos = (T[]) new Object[CAPACIDAD_INICIAL];
        this.cantDatos = 0;
    }

    // METODOS DE COMPORTAMIENTO
    public void agregar(T dato){
        considerarRedimension();
        this.datos[this.cantDatos] = dato;
        this.cantDatos++;
    }

    public T obtener(int i){
        if (i < 0 || i >= this.cantDatos){
            throw new IndexOutOfBoundsException();
        }

        return this.datos[i];
    }

    public void insertar(int i, T dato){
        analizarIndice(i);

        considerarRedimension();
        for (int j = this.cantDatos - 1; j >= i; j--){
            this.datos[j + 1] = this.datos[j];
        }
        this.datos[i] = dato;
        this.cantDatos++;
    }

    private void considerarRedimension(){
        if (this.cantDatos == this.datos.length){
            this.datos = Arrays.copyOf(this.datos, this.datos.length * 2);
        }
    }

    public T eliminar(int i){
        analizarIndice(i);

        T datoEliminado = this.datos[i];
        for (int j = i; j < this.cantDatos - 1; j++){
            this.datos[j] = this.datos[j + 1];
        }
        this.cantDatos--;
        this.datos[this.cantDatos] = null;
        return datoEliminado;
    }

    private void analizarIndice(int i){
        if (i < 0 || i >= this.cantDatos){
            throw new IndexOutOfBoundsException();
        }
    }

    public int tamanio(){
        return this.cantDatos;
    }
}
