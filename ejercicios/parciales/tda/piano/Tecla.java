package parciales.tda.piano;

import java.util.Objects;

public class Tecla {
    private Nota nota;

    //CONSTRUCTORES
    public Tecla(Nota nota){
        this.nota = nota;
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        Tecla that = (Tecla) o;
        
        return Objects.equals(this.nota, that.nota);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(nota);
    }

    //GETTERS
    public Nota getNota(){
        return nota;
    }
}
