package parciales.lista.asistente;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AsistenteDeCompras {
    
    public List<Atuendo> comprarAtuendos(List<Atuendo> stockDeAtuendos, List<Comprador> compradores){
        // Tendría que agregar validaciones de null para stockDeAtuendos y compradores
        List<Atuendo> noComprados = new ArrayList<>(stockDeAtuendos);
        for (Comprador comprador : compradores){
            asignoAtuendos(noComprados, comprador);
        }

        return noComprados;
    }

    private void asignoAtuendos(List<Atuendo> stock, Comprador comprador){
        // Tengo que usar dos iteradores, para encontrar un par adecuado.
        ListIterator<Atuendo> primero = stock.listIterator();
        while (primero.hasNext()){
            Atuendo atuendo1 = primero.next();
            if (puedePagar(atuendo1.getPrecio(), comprador)){
                ListIterator<Atuendo> segundo = stock.listIterator(primero.nextIndex());
                while (segundo.hasNext()){
                    Atuendo atuendo2 = segundo.next();
                    if (puedeComprar(atuendo1, atuendo2, comprador)){
                        primero.remove();
                        stock.remove(atuendo2);
                        return;
                    }
                }
            }
        }
    }

    private boolean puedeComprar(Atuendo atuendo1, Atuendo atuendo2, Comprador comprador){
        return atuendo1.getColor().equals(atuendo2.getColor())
        && atuendo1.getTipo().equals(atuendo2.getTipo())
        && puedePagar(atuendo1.getPrecio() + atuendo2.getPrecio(), comprador);
    }

    private boolean puedePagar(double precio, Comprador comprador){
        return precio <= comprador.getPresupuesto();
    }
}
