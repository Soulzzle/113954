package parciales.tda.tren;

public class Tren {
    //ATRIBUTOS
    private Vagon[] vagones;

    //CONSTRUCTORES
    public Tren(Vagon[] vagones){
        if (vagones == null){
            throw new IllegalArgumentException("vagones no puede valer null.");
        }

        this.vagones = vagones;
    }

    //GETTERS
    public Vagon[] getVagones(){
        return vagones;
    }

    public int getCapacidadTotalPasajeros(){
        int capacidad = 0;
        for (Vagon vagon : vagones){
            capacidad += vagon.getCapacidadDePasajeros();
        }

        return capacidad;
    }
    
    public int getCapacidadRestantePasajeros(){
        int capacidad = 0;
        for (Vagon vagon : vagones){
            capacidad += vagon.getCapacidadDePasajerosRestante();
        }

        return capacidad;
    }

    public double getCapacidadTotalCarga(){
        int capacidad = 0;
        for (Vagon vagon : vagones){
            capacidad += vagon.getCapacidadDeCarga();
        }

        return capacidad;
    }

    public double getCapacidadRestanteCarga(){
        int capacidad = 0;
        for (Vagon vagon : vagones){
            capacidad += vagon.getCapacidadDeCargaRestante();
        }

        return capacidad;
    }

    public int getCantidadDeVagones(){
        for (int i = 0; i < vagones.length; i++){
            if (vagones[i] == null){
                return i;
            }
        }

        return vagones.length;
    }

    public int getCantidadMaximaDeVagones(){
        return vagones.length;
    }
}
