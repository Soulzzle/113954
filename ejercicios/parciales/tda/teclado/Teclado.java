package parciales.tda.teclado;

import java.util.Vector;

public class Teclado {
    private static final char SHIFT = '\0';
    private Vector<Tecla> teclas;
    private Vector<Tecla> historial;

    //CONSTRUCTORES
    public Teclado(Vector<Tecla> teclas){
        this.teclas = new Vector<>(teclas); 
        Tecla shift = new Tecla(SHIFT);
        if (!this.teclas.contains(shift)){
            this.teclas.add(shift);
        }

        this.historial = new Vector<>();
    }

    //METODOS DE COMPORTAMIENTO
    public void presionarTecla(Tecla tecla){
        if (tecla == null || !this.teclas.contains(tecla)){
            throw new IllegalArgumentException();
        }

        this.historial.add(tecla);
    }

    public String obtenerTextoIngresado(){
        StringBuilder texto = new StringBuilder();
        boolean shiftActivo = false;
        for (Tecla tecla : historial){
            if (tecla.getCaracter() == SHIFT){
                shiftActivo = true;
            } else {
                if (shiftActivo){
                    texto.append(Character.toUpperCase(tecla.getCaracter()));
                    shiftActivo = false;
                } else {
                    texto.append(tecla.getCaracter());
                }
            }
        }
        return texto.toString();
    }

    public int obtenerCantidadDeLetras(){
        return historial.size();
    }

    public Tecla obtenerTeclaMasPresionada(){
        if (historial.size() == 0){
            throw new IllegalStateException();
        }
        Tecla teclaMasPresionada = historial.getFirst();
        int mejorContador = 0;
        for (Tecla tecla1 : teclas){
            int contador = aparicionesDeTeclaEnHistorial(tecla1);
            if (contador > mejorContador){
                teclaMasPresionada = tecla1;
                mejorContador = contador;
            }
        }
        return teclaMasPresionada;
    }

    private int aparicionesDeTeclaEnHistorial(Tecla tecla1){
        int resultado = 0;
        for (Tecla tecla2 : historial){
            if (tecla1.equals(tecla2)){
                resultado++;
            }
        }
        return resultado;
    }

    //GETTERS
    public Vector<Tecla> getTeclas(){
        return this.teclas;
    }

    public Vector<Tecla> getHistorial(){
        return this.historial;
    }
}
