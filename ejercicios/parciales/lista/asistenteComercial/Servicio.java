package parciales.lista.asistenteComercial;

import java.util.Objects;

public class Servicio {
    private String nombre;
    private boolean adicional;

    public Servicio(String nombre, boolean adicional){
        if (nombre == null){
            throw new IllegalArgumentException();
        }

        this.nombre = nombre;
        this.adicional = adicional;
    }

    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Servicio that = (Servicio) o;
        return Objects.equals(this.nombre, that.nombre);
    }

    public int hashCode(){
        return Objects.hashCode(nombre);
    }

    public String getNombre(){
        return nombre;
    }

    public boolean esAdicional(){
        return adicional;
    }
}
