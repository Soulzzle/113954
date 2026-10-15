package parciales.lista.ingeniero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProyectosDeProgramador {
    private Programador programador;
    private List<Proyecto> proyectos;

    //CONSTRUCTORES
    public ProyectosDeProgramador(Programador programador){
        this.programador = programador;
        this.proyectos = new ArrayList<>();
    }

    public ProyectosDeProgramador(Proyecto proyecto){
        this.programador = proyecto.getProgramador();
        this.proyectos = new ArrayList<>();
        this.proyectos.add(proyecto);
    }

    //METODOS GENERALES
    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()){
            return false;
        }
        ProyectosDeProgramador that = (ProyectosDeProgramador) o;
        return Objects.equals(this.programador, that.programador);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(programador);
    }

    //GETTERS
    public Programador getProgramador(){
        return this.programador;
    }

    public List<Proyecto> getProyectos(){
        return this.proyectos;
    }

    public int getCantidadDeProyectosEnProceso(){
        int contador = 0;
        for (Proyecto proyecto : this.proyectos){
            if (proyecto.getEstado() == EstadoDeProyecto.EN_PROCESO){
                contador++;
            }
        }

        return contador;
    }

    public double getPuntajeTotal(){
        double puntaje = 0;
        for (Proyecto proyecto : this.proyectos){
            puntaje += proyecto.getPuntaje();
        }

        return puntaje;
    }
}
