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
     * @pre solucionesDisponibles y solucionRequerida no son null. Ninguna solución, lista de compuestos ni compuesto
     *      involucrado es null.
     * @post Retorna una lista nueva, en el orden original, con las soluciones disponibles que cumplen las condiciones.
     *       No modifica solucionesDisponibles ni sus elementos.
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

    /**
     * Agrega la solución a la lista de equivalentes si cumple las condiciones requeridas.
     * @pre solucionesEquivalentes, solucion y solucionRequerida no son null; los compuestos involucrados tampoco.
     * @post Si solucionCumpleCondiciones(solucion, solucionRequerida) es true, agrega solucion al final de
     *       solucionesEquivalentes; en caso contrario, no modifica la lista.
     */
    private void buscoSolucionEquivalente(List<Solucion> solucionesEquivalentes, Solucion solucion, Solucion solucionRequerida){
        if (solucionCumpleCondiciones(solucion, solucionRequerida)){
            solucionesEquivalentes.add(solucion);
        }
    }

    /**
     * Determina si una solución cumple las condiciones de equivalencia respecto de la solución requerida.
     * @pre solucion y solucionRequerida no son null; sus listas de compuestos y los elementos de esas listas tampoco.
     * @post Retorna true si ambas soluciones tienen la misma cantidad de compuestos y cada compuesto requerido
     *       tiene algún compuesto compatible en solucion; false en caso contrario.
     */
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

    /**
     * Busca si existe en la lista un compuesto compatible con el compuesto requerido.
     * @pre compuestoRequerido y compuestos no son null; los elementos de compuestos tampoco.
     * @post Retorna true si al menos un compuesto de compuestos es compatible con compuestoRequerido;
     *       false si ninguno lo es.
     */
    private boolean hayCompuestoCompatible(Compuesto compuestoRequerido, List<Compuesto> compuestos){
        for (Compuesto compuesto : compuestos){
            if (esCompuestoCompatible(compuestoRequerido, compuesto)){
                    return true;
            }
        }

        return false;
    }

    /**
     * Comprueba la compatibilidad entre dos compuestos.
     * @pre compuestoRequerido y compuesto no son null.
     * @post Retorna true si ambos compuestos son iguales y la cantidad de compuesto está entre la cantidad
     *       requerida y el doble de esta, inclusive; false en caso contrario.
     */
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
