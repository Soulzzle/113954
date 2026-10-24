package parciales.lista.ingenieroQuimico;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Solucion {
    private final String codigo;
    private List<Compuesto> compuestos;

    //CONSTRUCTORES
    public Solucion(String codigo){
        if (codigo == null){
            throw new IllegalArgumentException("codigo no puede ser null.");
        }

        this.codigo = codigo;
        this.compuestos = new ArrayList<>();
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Solucion that = (Solucion) o;

        return Objects.equals(this.codigo, that.codigo);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(codigo);
    }

    //METODOS DE COMPORTAMIENTO
    public void agregarCompuesto(Compuesto compuesto){
        if (compuesto == null){
            throw new IllegalArgumentException("compuesto no puede ser null.");
        }

        this.compuestos.add(compuesto);
    }

    //GETTERS
    public String obtenerCodigo(){
        return codigo;
    }

    public List<Compuesto> obtenerCompuestos(){
        return compuestos;
    }
}
