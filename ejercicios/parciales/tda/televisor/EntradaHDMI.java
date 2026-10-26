package parciales.tda.televisor;

public class EntradaHDMI extends Entrada {
    //ATRIBUTOS
    private int numero;

    //CONSTRUCTORES
    public EntradaHDMI(int numero){
        if (numero < 0){
            throw new IllegalArgumentException("El numero de entrada HDMI no puede ser menor a 0.");
        }

        super();
        this.numero = numero;
    }

    //GETTERS
    public int getNumero(){
        return numero;
    }
}
