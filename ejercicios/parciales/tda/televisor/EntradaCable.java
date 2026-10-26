package parciales.tda.televisor;

public class EntradaCable extends Entrada {
    private final int CANTIDAD_MIN_CANALES = 1;
    //ATRIBUTOS
    private int canalesDisponibles;
    private int canalActual;

    //CONSTRUCTORES
    public EntradaCable(int canalesDisponibles){
        if (canalesDisponibles < 1){
            throw new IllegalArgumentException("La cantidad de canales disponibles no puede ser menor a 0.");
        }

        super();
        this.canalActual = 1;
        this.canalesDisponibles = canalesDisponibles;
    }

    //METODOS DE COMPORTAMIENTO
    public void cambiarDeCanal(int canal){
        if (canal < CANTIDAD_MIN_CANALES || canal > canalesDisponibles){
            throw new IllegalArgumentException("El canal tiene que estar dentro del rango de canales disponibles.");
        }

        canalActual = canal;
    }

    //GETTERS
    public int getCanalesDisponibles(){
        return canalesDisponibles;
    }

    public int getCanalActual(){
        return canalActual;
    }
}
