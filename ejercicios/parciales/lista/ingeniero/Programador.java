package parciales.lista.ingeniero;

import java.util.Objects;

public class Programador {
    private String nombre;

    //CONSTRUCTORES
    public Programador(String nombre){
        this.nombre = nombre;
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        Programador that = (Programador) o;
        return Objects.equals(this.nombre, that.nombre);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(nombre);
    }

    //GETTERS
    public String getNombre(){
        return this.nombre;
    }
}
