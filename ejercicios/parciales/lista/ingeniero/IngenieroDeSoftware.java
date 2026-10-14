package parciales.lista.ingeniero;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IngenieroDeSoftware {
    private final int CANTIDAD_PROGRAMADORES_RECORD = 10;

    public List<Programador> buscarProgramadoresMasCualificados(List<Proyecto> proyectos, int cantidadMaximaDeProyectos){
        List<ProyectosDeProgramador> programadoresCualificados = new ArrayList<>();
        //UNIFICO LOS PROYECTOS CON CADA PROGRAMADOR
        List<ProyectosDeProgramador> proyectosDeProgramadores = buscarProyectosDeProgramadores(proyectos);
        //ANALIZO QUE CADA PROGRAMADOR CUMPLA LAS CONDICIONES
        for (ProyectosDeProgramador proyectosDeProgramador : proyectosDeProgramadores){
            if (proyectosDeProgramador.getCantidadDeProyectosEnProceso() <= cantidadMaximaDeProyectos){
                programadoresCualificados.add(proyectosDeProgramador);
            }
        }

        //ORDENO POR PUNTAJE DE MAYOR A MENOR
        

        //PASO A RESULTADO LOS 10 PROGRAMADORES MAS CUALIFICADOS
        List<Programador> resultado = new ArrayList<>();

        return resultado;
    }

    private List<ProyectosDeProgramador> buscarProyectosDeProgramadores(List<Proyecto> proyectos){
        List<ProyectosDeProgramador> ProyectosDeProgramadores = new ArrayList<>();
        for(Proyecto proyecto : proyectos){
            ProyectosDeProgramadores.add(new ProyectosDeProgramador(proyecto));
        }

        return ProyectosDeProgramadores;
    }

    
}
