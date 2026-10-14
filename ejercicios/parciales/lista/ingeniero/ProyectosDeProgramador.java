package parciales.lista.ingeniero;

import java.util.ArrayList;
import java.util.List;

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
        this.proyectos.add(proyecto);
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

    public int getPuntajeTotal(){
        int puntaje = 0;
        for (Proyecto proyecto : this.proyectos){
            puntaje += proyecto.getPuntaje();
        }

        return puntaje;
    }
}
