package parciales.lista.asistenteComercial;

import java.util.List;
import java.util.ArrayList;

public class AsistenteComercial {

    // devuelve null si no hay ningun plan que cumpla las condiciones.
    public PlanComercial elegirPlanMasEconomico(List<PlanComercial> planesDisponibles, List<String> serviciosRequeridos){
        if (planesDisponibles == null || serviciosRequeridos == null){
            throw new IllegalArgumentException();
        }

        List<PlanComercial> planesElegibles = devolverPlanesElegibles(planesDisponibles, serviciosRequeridos);
        if (planesElegibles.size() == 0){
            return null;
        }
        PlanComercial mejorPlan = planesElegibles.getFirst();
        for (PlanComercial plan : planesElegibles){
            if (plan.getPrecio() < mejorPlan.getPrecio()){
                mejorPlan = plan;
            }
        }

        return mejorPlan;
    }

    private List<PlanComercial> devolverPlanesElegibles(List<PlanComercial> planesDisponibles, List<String> serviciosRequeridos){
        if (planesDisponibles == null || serviciosRequeridos == null){
            throw new IllegalArgumentException();
        }

        List<PlanComercial> planesElegibles = new ArrayList<>();
        for (PlanComercial plan : planesDisponibles){
            if (contieneServicios(plan, serviciosRequeridos)){
                planesElegibles.add(plan);
            }
        }

        return planesElegibles;
    }

    private boolean contieneServicios(PlanComercial plan, List<String> servicios){
        if (plan == null || servicios == null){
            throw new IllegalArgumentException();
        }

        if (plan.getServicios().size() < servicios.size()){
            return false;
        }

        for (String nombreDeServicio : servicios){
            Servicio servicio = new Servicio(nombreDeServicio, false);
            if (!servicioIncluidoEnPlan(plan, servicio)){
                return false;
            }
        }

        return true;
    }

    private boolean servicioIncluidoEnPlan(PlanComercial plan, Servicio servicio){
        for (Servicio servicio2 : plan.getServicios()){
            if (servicio2.equals(servicio) && !servicio2.esAdicional()){
                return true;
            }
        }

        return false;
    }
}
