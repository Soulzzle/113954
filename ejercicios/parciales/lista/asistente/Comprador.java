package parciales.lista.asistente;

public class Comprador {
    private String nombre;
    private double presupuesto;

    //CONSTRUCTORES
    public Comprador(String nombre, double presupuesto){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        if (presupuesto < 0){
            throw new IllegalArgumentException("El presupuesto no puede ser negativo.");
        }
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }    

    //GETTERS
    public String getNombre(){
        return this.nombre;
    }

    public double getPresupuesto(){
        return this.presupuesto;
    }
}
