package parciales.tda.piano;

import java.util.Vector;

public class Piano {
    //ATRIBUTOS
    private Vector<Tecla> teclas;
    private Vector<Tecla> historial;

    //CONSTRUCTORES
    public Piano(Vector<Tecla> teclas){
        if (teclas == null || teclas.size() == 0){
            throw new IllegalArgumentException("El vector teclas no puede estar vacío.");
        }
        this.teclas = new Vector<>(teclas);
        this.historial = new Vector<>();
    }

    //METODOS DE COMPORTAMIENTO
    public void presionarTecla(Tecla tecla){
        if (!teclas.contains(tecla)){
            throw new IllegalArgumentException();
        }

        historial.add(tecla);
    }

    public Vector<Nota> obtenerMelodia(){
        if (historial.size() == 0){
            throw new IllegalStateException("No hay notas para buscar.");
        }
        Vector<Nota> resultado = new Vector<>();
        for (Tecla tecla : historial){
            resultado.add(tecla.getNota());
        }

        return resultado;
    }

    public Tecla buscarTeclaMasPresionada(){
        if (historial.size() == 0 || teclas.size() == 0){
            throw new IllegalStateException("No hay teclas para buscar.");
        }
        Tecla teclaMasPresionada = teclas.getFirst();
        int mejorContador = 0;
        for (Tecla tecla : teclas){
            int contadorActual = buscarRepeticionesDeTecla(tecla);
            if (contadorActual > mejorContador){
                teclaMasPresionada = tecla;
                mejorContador = contadorActual;
            }
        }
        
        return teclaMasPresionada;
    }
    
    private int buscarRepeticionesDeTecla(Tecla tecla){
        int contadorActual = 0;
        for (Tecla tecla2 : historial){
            if (tecla.equals(tecla2)){
                contadorActual++;
            }
        }
        
        return contadorActual;
    }

    public int totalDeTeclasPresionadas(){
        return historial.size();
    }
}
