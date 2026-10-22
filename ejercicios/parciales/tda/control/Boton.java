package parciales.tda.control;

import java.util.Objects;

public class Boton {
    //ATRIBUTOS
    private int canal;

    //CONSTRUCTORES
    public Boton(int canal){
        if (canal < 0){
            throw new IllegalArgumentException("El canal no puede ser negativo.");
        }
        this.canal = canal;
    }

    //METODOS GENERALES
    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Boton that = (Boton) o;

        return this.canal == that.canal;
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(canal);
    }

    //GETTERS
    public int getCanal(){
        return canal;
    }
}
