package parciales.lista.ingeniero;

public class Proyecto {
    private Programador programador; 
    private double puntaje; 
    private EstadoDeProyecto estado;

    //CONSTRUCTORES
    public Proyecto(Programador programador, double puntaje, EstadoDeProyecto estado){
        this.programador = programador;
        this.puntaje = puntaje;
        this.estado = estado;
    }

    //GETTERS
    public Programador getProgramador(){
        return this.programador;
    }

    public double getPuntaje(){
        return this.puntaje;
    }

    public EstadoDeProyecto getEstado(){
        return this.estado;
    }
}
