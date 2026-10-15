package parciales.lista.asistente;

import java.util.List;

public class AsistenteDeCompras {
    
    public List<Atuendo> comprarAtuendos(List<Atuendo> stockDeAtuendos, List<Comprador> compradores){
        for (Comprador comprador : compradores){
            asignoAtuendos(stockDeAtuendos, comprador);
        }

        return stockDeAtuendos;
    }

    public void asignoAtuendos(List<Atuendo> stock, Comprador comprador){
        // Tengo que iterar con It1 e It2, buscando un par adecuado.
    }

    public boolean cumplenCondiciones(Atuendo a1, Atuendo a2){
        return false;
    }
}
