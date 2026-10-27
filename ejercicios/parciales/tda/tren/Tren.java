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

    //METODOS DE COMPORTAMIENTO
    public void agregarVagon(Vagon vagon){
        if (vagon == null){
            throw new IllegalArgumentException("vagon no puede valer null.");
        }

        int indice = getCantidadDeVagones();
        if (indice == vagones.length){
            throw new IllegalStateException("vagones ya está en su máxima capacidad.");
        }

        vagones[indice] = vagon;
    }

    public Vagon quitarVagon(int posicionDeVagon){
        if (posicionDeVagon < 0 || posicionDeVagon >= getCantidadDeVagones()){
            throw new IllegalArgumentException("posicionDeVagon tiene que ser mayor a 0 y menor a la cantidad de vagones.");
        }

        Vagon vagonQuitado = vagones[posicionDeVagon];
        for (int i = posicionDeVagon; i < getCantidadDeVagones() - 1; i++){
            vagones[i] = vagones[i + 1];
        }

        return vagonQuitado;
    }

    public void agregarCarga(double carga){
        if (carga > getCapacidadRestanteCarga()){
            throw new IllegalArgumentException("carga no puede ser mayor a la capacidad de carga restante del tren.");
        }

        int i = 0;
        while (i < getCantidadDeVagones() && carga > 0){
            double capacidadDeCargaRestante = vagones[i].getCapacidadDeCargaRestante();
            if (carga > capacidadDeCargaRestante){
                vagones[i].agregarCarga(capacidadDeCargaRestante);
                carga -= capacidadDeCargaRestante;
            } else {
                vagones[i].agregarCarga(carga);
                carga -= carga;
            }
            i++;
        }
    }

    public void agregarPasajeros(int pasajeros){
        if (pasajeros > getCapacidadRestantePasajeros()){
            throw new IllegalArgumentException("pasajeros no puede ser mayor a la capacidad de pasajeros restante del tren.");
        }

        int i = 0;
        while (i < getCantidadDeVagones() && pasajeros > 0){
            int capacidadDePasajerosRestante = vagones[i].getCapacidadDePasajerosRestante();
            if (pasajeros > capacidadDePasajerosRestante){
                vagones[i].agregarPasajeros(capacidadDePasajerosRestante);
                pasajeros -= capacidadDePasajerosRestante;
            } else {
                vagones[i].agregarPasajeros(pasajeros);
                pasajeros -= pasajeros;
            }
            i++;
        }
    }

    //GETTERS
    public Vagon[] getVagones(){
        return vagones;
    }

    public double getLongitudTotal(){
        double longitud = 0;
        for (int i = 0; i < getCantidadDeVagones(); i++){
            longitud += vagones[i].getLongitud();
        }

        return longitud;
    }

    public int getCapacidadTotalPasajeros(){
        int capacidad = 0;
        for (int i = 0; i < getCantidadDeVagones(); i++){
            capacidad += vagones[i].getCapacidadDePasajeros();
        }

        return capacidad;
    }
    
    public int getCapacidadRestantePasajeros(){
        int capacidad = 0;
        for (int i = 0; i < getCantidadDeVagones(); i++){
            capacidad += vagones[i].getCapacidadDePasajerosRestante();
        }

        return capacidad;
    }

    public double getCapacidadTotalCarga(){
        int capacidad = 0;
        for (int i = 0; i < getCantidadDeVagones(); i++){
            capacidad += vagones[i].getCapacidadDeCarga();
        }

        return capacidad;
    }

    public double getCapacidadRestanteCarga(){
        int capacidad = 0;
        for (int i = 0; i < getCantidadDeVagones(); i++){
            capacidad += vagones[i].getCapacidadDeCargaRestante();
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
