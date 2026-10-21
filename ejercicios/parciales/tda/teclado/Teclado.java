package parciales.tda.teclado;

import java.util.Vector;

public class Teclado {
    private Vector<Tecla> teclas;
    private Vector<Tecla> historial;

    //CONSTRUCTORES
    public Teclado(){
        this.teclas = new Vector<>(); 
        this.historial = new Vector<>();
    }

    //METODOS DE COMPORTAMIENTO
    public String obtenerTextoIngresado(){
        StringBuilder texto = new StringBuilder();
        for (Tecla tecla : teclas){
            texto.append(tecla.getCaracter());
        }
        return texto.toString();
    }

    //GETTERS
    public Vector<Tecla> getTeclas(){
        return this.teclas;
    }

    public Vector<Tecla> getHistorial(){
        return this.historial;
    }
}
