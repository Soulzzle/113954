package parciales.tda.teclado;

import java.util.Objects;

public class Tecla {
    private char caracter;

    //CONSTRUCTORES
    public Tecla(char caracter){
        this.caracter = caracter;
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Tecla that = (Tecla) o;
        return this.caracter == that.caracter;
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(this.caracter);
    }

    //GETTERS
    public char getCaracter(){
        return this.caracter;
    }
}
