package parciales.lista.ingenieroQuimico;

import java.util.List;
import java.util.ArrayList;

public class IngenieroQuimico {
    
    //METODOS DE COMPORTAMIENTO
    /**
     * busca en 'soluciones' las Soluciones que tengan los mismos compuestos que 'solucionRequerida' con cantidades 
     * iguales o superiores, pero menores o iguales al doble.
     * @param solucionesDisponibles
     * @param solucionRequerida
     * @return Lista de soluciones que cumplan las condiciones.
     */
    public List<Solucion> buscarSolucionesEquivalentes(List<Solucion> solucionesDisponibles, Solucion solucionRequerida){
        if (solucionRequerida == null){
            throw new IllegalArgumentException("La solucion requerida no puede ser nula");
        }
        if (solucionesDisponibles == null){
            throw new IllegalArgumentException("Las soluciones disponibles no pueden ser nulas");
        }

        List<Solucion> solucionesEquivalentes = new ArrayList<>();
        for (Solucion solucion : solucionesDisponibles){
            buscoSolucionEquivalente(solucionesEquivalentes, solucion, solucionRequerida);
        }

        return solucionesEquivalentes;
    }

    private void buscoSolucionEquivalente(List<Solucion> solucionesEquivalentes, Solucion solucion, Solucion solucionRequerida){
        if (solucionCumpleCondiciones(solucion, solucionRequerida)){
            solucionesEquivalentes.add(solucion);
        }
    }

    private boolean solucionCumpleCondiciones(Solucion solucion, Solucion solucionRequerida){
        if (solucion.obtenerCompuestos().size() != solucionRequerida.obtenerCompuestos().size()){
            return false;
        }
        for (Compuesto compuestoRequerido : solucionRequerida.obtenerCompuestos()){
            if (!hayCompuestoCompatible(compuestoRequerido, solucion.obtenerCompuestos())){
                return false;
            }
        }

        return true;
    }

    private boolean hayCompuestoCompatible(Compuesto compuestoRequerido, List<Compuesto> compuestos){
        for (Compuesto compuesto : compuestos){
            if (esCompuestoCompatible(compuestoRequerido, compuesto)){
                    return true;
            }
        }

        return false;
    }

    private boolean esCompuestoCompatible(Compuesto compuestoRequerido, Compuesto compuesto){
        if (compuesto.equals(compuestoRequerido)){
            if (compuesto.obtenerCantidad() >= compuestoRequerido.obtenerCantidad() 
                && compuesto.obtenerCantidad() <= compuestoRequerido.obtenerCantidad()*2){
                    return true;
            }
        }

        return false;
    }
}
