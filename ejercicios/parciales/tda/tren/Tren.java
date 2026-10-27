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

        for (int i = 0; i < getCantidadDeVagones() && carga > 0; i++){
            double capacidadDeCargaRestante = vagones[i].getCapacidadDeCargaRestante();
            if (carga > capacidadDeCargaRestante){
                vagones[i].agregarCarga(capacidadDeCargaRestante);
                carga -= capacidadDeCargaRestante;
            } else {
                vagones[i].agregarCarga(carga);
                carga -= carga;
            }
        }
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
