package parciales.tda.televisor;

public abstract class Entrada {
    //ATRIBUTOS
    private Estado estadoDeEntrada;
    private int tiempoDeUso;

    //CONSTRUCTORES
    public Entrada(){
        this.estadoDeEntrada = Estado.INACTIVO;
        this.tiempoDeUso = 0;
    }

    //METODOS DE COMPORTAMIENTO
    public void aumentarTiempoDeUso(){
        tiempoDeUso++;
    }

    public void activarEntrada(){
        if (estadoDeEntrada == Estado.INACTIVO){
            estadoDeEntrada = Estado.ACTIVO;
        }
    }

    public void desactivarEntrada(){
        if (estadoDeEntrada == Estado.ACTIVO){
            estadoDeEntrada = Estado.INACTIVO;
        }
    }

    //GETTERS
    public Estado getEstadoDeEntrada(){
        return estadoDeEntrada;
    }

    public int getTiempoDeUso(){
        return tiempoDeUso;
    }
}
