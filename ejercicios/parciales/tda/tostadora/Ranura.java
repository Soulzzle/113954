package parciales.tda.tostadora;

public class Ranura {
    //ATRIBUTOS
    private int numero;
    private boolean enUso;
    private int cantidadDeUsos;

    //CONSTRUCTORES
    public Ranura(int numero){
        if (numero < 0){
            throw new IllegalArgumentException("numero no puede ser menor a 0.");
        }

        this.numero = numero;
        this.enUso = false;
        this.cantidadDeUsos = 0;
    }

    //METODOS DE COMPORTAMIENTO
    public void usarRanura(){
        if (!enUso){
            enUso = true;
            cantidadDeUsos++;
        }
    }

    public void desocuparRanura(){
        if (enUso){
            enUso = false;
        }
    }

    //GETTERS
    public int getNumero(){
        return numero;
    }

    public boolean estaEnUso(){
        return enUso;
    }

    public int getCantidadDeUsos(){
        return cantidadDeUsos;
    }
}
