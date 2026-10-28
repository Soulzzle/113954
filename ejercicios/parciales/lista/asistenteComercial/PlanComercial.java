package parciales.lista.asistenteComercial;

import java.util.List;
import java.util.ArrayList;

public class PlanComercial {
    private int precio;
    private List<Servicio> servicios;

    public PlanComercial(int precio){
        if (precio < 0){
            throw new IllegalArgumentException();
        }

        this.precio = precio;
        this.servicios = new ArrayList<>();
    }

    public int getPrecio(){
        return precio;
    }

    public List<Servicio> getServicios(){
        return servicios;
    }
}
