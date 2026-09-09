package tp1;

import java.util.Arrays;
import java.util.Objects;

public class RegistroSobreArreglo implements RegistroDePrestamos {
    
    private static final int CAPACIDAD_INICIAL = 8;

    //ATRIBUTOS

    private Prestamo[] prestamos;
    private int cantidad;

    //CONSTRUCTORES

    public RegistroSobreArreglo(){
        this.prestamos = new Prestamo[CAPACIDAD_INICIAL];
        this.cantidad = 0;
    }

    //METODOS DE COMPORTAMIENTO

    @Override 
    public void registrar(Prestamo p){
        Objects.requireNonNull(p, "El prestamo a registrar no puede ser nulo.");

        if(this.cantidad == this.prestamos.length){
            this.prestamos = Arrays.copyOf(this.prestamos, this.prestamos.length * 2);
        }
        this.prestamos[cantidad] = p;
        this.cantidad++;
    }

    @Override 
    public int cantidad(){
        return this.cantidad;
    }

    @Override
    public Prestamo obtener(int i){ // IndexOutOfBoundsException si i es invalido
        if (i < 0 || i > this.cantidad-1){
            throw new IndexOutOfBoundsException("i tiene que estar dentro del rango.");
        }

        return this.prestamos[i];
    }

    private static boolean padronYaAnotado(int[] padrones, int padronActual, int topePadrones){
        for (int i = 0; i < topePadrones; i++){
            if (padrones[i] == padronActual){
                return true;
            }
        }
        return false;
    }

    @Override 
    public int[] padrones(){ // sin repetidos, en orden de aparicion
        int[] padrones = new int[this.cantidad];
        int topePadrones = 0;
        for (int i = 0; i < this.cantidad; i++){
            int padronActual = this.prestamos[i].padron();
            if (!padronYaAnotado(padrones, padronActual, topePadrones)){
                padrones[topePadrones] = padronActual;
                topePadrones++;
            }
        }

        padrones = Arrays.copyOf(padrones, topePadrones);
        return padrones;
    }

    @Override
    public Prestamo[] prestamosDe(int padron){ // arreglo vacio si no hay ninguno
        Prestamo[] prestamos = new Prestamo[this.cantidad];
        int topePrestamos = 0;
        for (int i = 0; i < this.cantidad; i++){
            if (this.prestamos[i].padron() == padron){
                prestamos[topePrestamos] = this.prestamos[i];
                topePrestamos++;
            }
        }

        prestamos = Arrays.copyOf(prestamos, topePrestamos);
        return prestamos;
    }

    public String[] titulosMasPedidos(int n){ // los n mas pedidos, desempate alfabetico
        
    }
}
