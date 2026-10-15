package parciales.lista.asistente;

import java.util.Objects;

public class Atuendo {
    private String tipo;
    private String color;
    private double precio;

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Atuendo that = (Atuendo) o;

        return (Objects.equals(this.tipo, that.tipo) && Objects.equals(this.color, that.color) && Objects.equals(this.precio, that.precio));
    }

    @Override 
    public int hashCode(){
        return Objects.hash(tipo, color, precio);
    }

    //GETTERS
    public String getTipo(){
        return this.tipo;
    }

    public String getColor(){
        return this.color;
    }

    public double getPrecio(){
        return this.precio;
    }
}
