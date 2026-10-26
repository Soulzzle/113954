package parciales.tda.televisor;

public class Televisor {
    private final int CANTIDAD_CANALES = 140;
    //ATRIBUTOS
    private Entrada[] entradas;
    private int entradaActual;

    //CONSTRUCTORES
    public Televisor(int cantidadEntradasHDMI){
        if (cantidadEntradasHDMI < 0){
            throw new IllegalArgumentException("cantidadEntradasHDMI no puede ser menor a 0.");
        }

        this.entradas = new Entrada[cantidadEntradasHDMI + 1];
        this.entradas[0] = new EntradaCable(CANTIDAD_CANALES);
        for (int i = 1; i < cantidadEntradasHDMI + 1; i++){
            this.entradas[i] = new EntradaHDMI(i);
        }
        this.entradaActual = 0;
    }

    //METODOS DE COMPORTAMIENTO
    public void seleccionarEntrada(int numeroDeEntrada){
        if (numeroDeEntrada < 0 || numeroDeEntrada >= entradas.length){
            throw new IllegalArgumentException("numeroDeEntrada no puede ser menor a 0 ni mayor a la cantidad máxima de entradas.");
        }

        if (entradaActual != numeroDeEntrada && entradas[numeroDeEntrada].getEstadoDeEntrada() == Estado.ACTIVO){
            entradaActual = numeroDeEntrada;
            entradas[numeroDeEntrada].aumentarTiempoDeUso();
        }
    }

    public void activarEntradaHDMI(int numeroDeEntrada){
        if (numeroDeEntrada < 1 || numeroDeEntrada >= entradas.length){
            throw new IllegalArgumentException("numeroDeEntrada no puede ser menor a 1 ni mayor a la cantidad máxima de entradas.");
        }

        entradas[numeroDeEntrada].activarEntrada();
    }

    public void desactivarEntradaHDMI(int numeroDeEntrada){
        if (numeroDeEntrada < 1 || numeroDeEntrada >= entradas.length){
            throw new IllegalArgumentException("numeroDeEntrada no puede ser menor a 1 ni mayor a la cantidad máxima de entradas.");
        }

        entradas[numeroDeEntrada].desactivarEntrada();
    }

    public void siguienteCanal(){
        if (entradaActual != 0){
            throw new IllegalStateException("entradaActual debe ser 0 (cable) para poder cambiar de canal.");
        }

        Entrada entradaCable = entradas[0];
        int siguienteCanal = ((EntradaCable) entradaCable).getCanalActual() + 1;
        ((EntradaCable) entradaCable).cambiarDeCanal(siguienteCanal);
    }

    public void anteriorCanal(){
        if (entradaActual != 0){
            throw new IllegalStateException("entradaActual debe ser 0 (cable) para poder cambiar de canal.");
        }

        Entrada entradaCable = entradas[0];
        int anteriorCanal = ((EntradaCable) entradaCable).getCanalActual() - 1;
        ((EntradaCable) entradaCable).cambiarDeCanal(anteriorCanal);
    }

    public void seleccionarCanal(int canal){
        if (entradaActual != 0){
            throw new IllegalStateException("entradaActual debe ser 0 (cable) para poder cambiar de canal.");
        }

        Entrada entradaCable = entradas[0];
        ((EntradaCable) entradaCable).cambiarDeCanal(canal);
    }

    public Entrada entradaMasUsada(){
        Entrada entradaMasUsada = null;
        float mejorTiempoDeUso = 0;
        for (Entrada entrada : entradas){
            if (entrada.getTiempoDeUso() > mejorTiempoDeUso){
                entradaMasUsada = entrada;
                mejorTiempoDeUso = entrada.getTiempoDeUso();
            }
        }

        return entradaMasUsada;
    }

    //GETTERS
    public Entrada[] getEntradas(){
        return entradas;
    }

    public int getEntradaActual(){
        return entradaActual;
    }
}
