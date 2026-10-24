package parciales.lista.ingenieroQuimico;

import java.util.Objects;

public class Compuesto {
    //ATRIBUTOS
    private String nombre;
    private Unidad unidad;
    private float cantidad;

    //CONSTRUCTORES
    public Compuesto(String nombre, Unidad unidadDeMedida){
        if (nombre == null || unidadDeMedida == null){
            throw new IllegalArgumentException("Los parámetros no pueden ser de valor nulo.");
        }
        this.nombre = nombre;
        this.unidad = unidadDeMedida;
        this.cantidad = 0;
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Compuesto that = (Compuesto) o;

        return Objects.equals(this.nombre, that.nombre);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(nombre);
    }

    //METODOS DE COMPORTAMIENTO
    public void cambiarCantidad(float cantidad){
        if (cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser inferior a 0.");
        }
        this.cantidad = cantidad;
    }

    //GETTERS
    public String obtenerNombre(){
        return nombre;
    }

    public Unidad obtenerUnidad(){
        return unidad;
    }

    public float obtenerCantidad(){
        return cantidad;
    }
}
