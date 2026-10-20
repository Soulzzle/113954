package parciales.tda.teclado;

public class Tecla {
    private char caracter;
    private boolean esShift;

    //CONSTRUCTORES
    public Tecla(char caracter){
        this.caracter = caracter;
    }

    public Tecla(){
        this.caracter = '\0'; //caracter vacío
        this.esShift = true;
    }

    //GETTERS
    public char getCaracter(){
        return this.caracter;
    }

    public boolean getEsShift(){
        return this.esShift;
    }
}
