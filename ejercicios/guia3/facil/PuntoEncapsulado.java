package guia3.facil;

// Punto encapsulado. Clase Punto con campos privados x, y, constructor y getters. Test
public class PuntoEncapsulado {
    private int x;
    private int y;

    // CONSTRUCTOR
    public PuntoEncapsulado(int x, int y){
        this.x = x;
        this.y = y;
    }

    // METODOS DE COMPORTAMIENTO
    public double modulo(){
        double modulo = Math.sqrt((this.x * this.x) + (this.y * this.y));
        return modulo;
    }

    // GETTERS
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}