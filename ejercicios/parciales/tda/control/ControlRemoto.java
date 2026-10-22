package parciales.tda.control;

import java.util.Vector;

public class ControlRemoto {
    //ATRIBUTOS
    private Vector<Boton> botones;
    private Vector<Boton> historial;
    private Boton botonFavorito;

    //CONSTRUCTORES
    public ControlRemoto(Vector<Boton> botones, int canalFavorito){
        if (botones == null || botones.size() == 0){
            throw new IllegalArgumentException("Debe haber al menos un botón.");
        }
        if (canalFavorito < 0){
            throw new IllegalArgumentException("El canal favorito no puede ser negativo.");
        }

        this.botones = new Vector<>(botones);
        this.historial = new Vector<>();
        cambiarBotonFavorito(canalFavorito);
    }

    public ControlRemoto(Vector<Boton> botones){
        if (botones == null || botones.size() == 0){
            throw new IllegalArgumentException("Debe haber al menos un botón.");
        }

        this.botones = new Vector<>(botones);
        this.historial = new Vector<>();
    }

    //METODOS DE COMPORTAMIENTO
    public void apretarBoton(Boton boton){
        if (!botones.contains(boton)){
            throw new IllegalArgumentException("El botón debe existir en el control remoto.");
        }

        historial.add(boton);
    }

    public void apretarBotonFavorito(){
        if (botonFavorito == null){
            throw new IllegalStateException("No hay un canal favorito actualmente.");
        }

        historial.add(botonFavorito);
    }

    public void marcarCanalFavorito(int canalFavorito){
        if (botones.size() == 0){
            throw new IllegalStateException("Debe haber al menos un botón disponible para ser favorito.");
        }
        if (canalFavorito < 0){
            throw new IllegalArgumentException("El canal favorito no puede ser negativo.");
        }

        cambiarBotonFavorito(canalFavorito);
    }

    private void cambiarBotonFavorito(int canalFavorito){
        Boton botonFavorito = new Boton(canalFavorito);
        if (!this.botones.contains(botonFavorito)){
            throw new IllegalArgumentException("El canal debe estar en la lista de botones disponibles.");
        }

        this.botonFavorito = botonFavorito;
    }

    public Boton obtenerBotonMasPresionado(){
        if (botones.size() == 0 || historial.size() == 0){
            throw new IllegalStateException("Debe haber al menos un botón disponible y presionado.");
        }

        Boton botonMasPresionado = botones.getFirst();
        int mejorContador = 0;
        for (Boton boton : botones){
            int contador = obtenerRepeticionesDeBoton(boton);
            if (contador > mejorContador){
                botonMasPresionado = boton;
                mejorContador = contador;
            }
        }

        return botonMasPresionado;
    }

    private int obtenerRepeticionesDeBoton(Boton boton){
        int contador = 0;
        for (Boton boton2 : historial){
            if (boton.equals(boton2)){
                contador++;
            }
        }

        return contador;
    }

    public Vector<Integer> obtenerHistorialDeCanales(){
        Vector<Integer> historial = new Vector<>();
        for (Boton boton : this.historial){
            historial.add(boton.getCanal());
        }

        return historial;
    }

    public int cantidadDeBotonesPresionados(){
        return historial.size();
    }

    //GETTERS
    public Vector<Boton> getBotones(){
        return botones;
    }

    public Vector<Boton> getHistorial(){
        return historial;
    }

    public Boton getBotonFavorito(){
        return botonFavorito;
    }
}
