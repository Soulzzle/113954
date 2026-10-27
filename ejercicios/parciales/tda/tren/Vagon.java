package parciales.tda.tren;

public class Vagon {
    //ATRIBUTOS
    private double capacidadDeCarga;
    private int capacidadDePasajeros;
    private double longitud;
    private double carga;
    private int pasajeros;

    //CONSTRUCTORES
    public Vagon(double capacidadDeCarga, int capacidadDePasajeros, double longitud){
        if (capacidadDeCarga < 0 || capacidadDePasajeros < 0 || longitud <= 0){
            throw new IllegalArgumentException("capacidadDeCarga, capacidadDePasajeros y longitud no pueden ser negativos.");
        }

        this.capacidadDeCarga = capacidadDeCarga;
        this.capacidadDePasajeros = capacidadDePasajeros;
        this.longitud = longitud;
        this.carga = 0;
        this.pasajeros = 0;
    }

    //METODOS DE COMPORTAMIENTO
    public void agregarCarga(double carga){
        if (carga > this.capacidadDeCarga - this.carga){
            throw new IllegalArgumentException("La carga no puede ser mayor a la capacidad restante.");
        }
    }

    //GETTERS
    public double getCapacidadDeCarga(){
        return capacidadDeCarga;
    }

    public int getCapacidadDePasajeros(){
        return capacidadDePasajeros;
    }

    public double getCapacidadDeCargaRestante(){
        return capacidadDeCarga - carga;
    }

    public int getCapacidadDePasajerosRestante(){
        return capacidadDePasajeros - pasajeros;
    }

    public double getCarga(){
        return carga;
    }

    public int getPasajeros(){
        return pasajeros;
    }

    public double getLongitud(){
        return longitud;
    }
}
