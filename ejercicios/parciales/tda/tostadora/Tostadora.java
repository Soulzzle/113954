package parciales.tda.tostadora;

public class Tostadora {
    //ATRIBUTOS
    private static final int NIVEL_CALOR_MINIMO = 1;
    private static final int NIVEL_CALOR_MAXIMO = 10;

    private Ranura[] ranuras;
    private int nivelDeCalor;
    private Estado estado;

    //CONSTRUCTORES
    public Tostadora(int cantidadDeRanuras){
        if (cantidadDeRanuras <= 0){
            throw new IllegalArgumentException("cantidadDeRanuras debe valen como mínimo 1.");
        }

        this.ranuras = new Ranura[cantidadDeRanuras];
        for (int i = 0; i < cantidadDeRanuras; i++){
            this.ranuras[i] = new Ranura(i);
        }
        this.nivelDeCalor = NIVEL_CALOR_MINIMO; // ARRANCA EN MINIMO
        this.estado = Estado.APAGADO;
    }

    //METODOS DE COMPORTAMIENTO
    public void prenderTostadora(){
        if (estado == Estado.APAGADO){
            estado = Estado.ENCENDIDO;
        }
    }

    public void apagarTostadora(){
        if (estado == Estado.ENCENDIDO){
            estado = Estado.APAGADO;
        }
    }

    public void iniciarTostado(int numeroRanura){
        if (estado == Estado.APAGADO){
            throw new IllegalStateException("No se puede llamar iniciarTostado si estado vale 'APAGADO'.");
        }
        if (numeroRanura < 0 || numeroRanura >= ranuras.length){
            throw new IllegalArgumentException("numeroRanura debe pertenecer a alguna ranura existente.");
        }
        
        if (!ranuras[numeroRanura].estaEnUso()){
            ranuras[numeroRanura].usarRanura();
        }
    }

    public void finalizarTostado(int numeroRanura){
        if (estado == Estado.APAGADO){
            throw new IllegalStateException("No se puede llamar finalizarTostado si estado vale 'APAGADO'.");
        }
        if (numeroRanura < 0 || numeroRanura >= ranuras.length){
            throw new IllegalArgumentException("numeroRanura debe pertenecer a alguna ranura existente.");
        }

        if (ranuras[numeroRanura].estaEnUso()){
            ranuras[numeroRanura].desocuparRanura();
        }
    }

    public void indicarNivelDeCalor(int nuevoNivel){
        if (nuevoNivel < NIVEL_CALOR_MINIMO || nuevoNivel > NIVEL_CALOR_MAXIMO){
            throw new IllegalArgumentException("nuevoNivel debe estar dentro del rango permitido (1-10).");
        }

        if (nivelDeCalor != nuevoNivel){
            nivelDeCalor = nuevoNivel;
        }
    }

    public int contarRanurasLibres(){
        int contador = 0;
        for (Ranura ranura : ranuras){
            if (!ranura.estaEnUso()){
                contador++;
            }
        }

        return contador;
    }

    public Ranura ranuraMasUsada(){
        Ranura ranuraMasUsada = null;
        int mayorCantidadDeUsos = 0;
        for (Ranura ranura : ranuras){
            if (ranura.getCantidadDeUsos() > mayorCantidadDeUsos){
                ranuraMasUsada = ranura;
                mayorCantidadDeUsos = ranura.getCantidadDeUsos();
            }
        }

        return ranuraMasUsada;
    }

    //GETTERS
    public Ranura[] getRanuras(){
        return ranuras;
    }

    public int getNivelDeCalor(){
        return nivelDeCalor;
    }

    public Estado getEstado(){
        return estado;
    }
}
