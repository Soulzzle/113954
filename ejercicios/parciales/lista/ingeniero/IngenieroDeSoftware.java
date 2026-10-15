package parciales.lista.ingeniero;

import java.util.ArrayList;
import java.util.List;

public class IngenieroDeSoftware {
    private final int CANTIDAD_PROGRAMADORES_RECORD = 10;

    /** Buscar los 10 programadores más cualificados.
    * Un programador será considerado más cualificado si posee mayor puntaje acumulado considerando todos sus proyectos.
    * Solo deben considerarse programadores que tengan como máximo cantidadMaximaDeProyectos proyectos en estado EN_PROCESO.
    * Un mismo programador puede aparecer en varios proyectos, pero en el resultado debe aparecer una sola vez.
    * El vector devuelto debe contener los programadores ordenados de mayor a menor puntaje acumulado.
    * Si existen menos de 10 programadores que cumplan las condiciones, devolver únicamente los disponibles.
    */

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
        programadoresCualificados.sort((o1, o2) -> Double.compare(o2.getPuntajeTotal(), o1.getPuntajeTotal()));

        //PASO A RESULTADO LOS 10 PROGRAMADORES MAS CUALIFICADOS
        List<Programador> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(CANTIDAD_PROGRAMADORES_RECORD, programadoresCualificados.size()); i++){
            resultado.add(programadoresCualificados.get(i).getProgramador());
        }

        return resultado;
    }

    private List<ProyectosDeProgramador> buscarProyectosDeProgramadores(List<Proyecto> proyectos){
        List<ProyectosDeProgramador> proyectosDeProgramadores = new ArrayList<>();
        for(Proyecto proyecto : proyectos){
            agregarProyectoAProgramador(proyectosDeProgramadores, proyecto);
        }

        return proyectosDeProgramadores;
    }

    private void agregarProyectoAProgramador(List<ProyectosDeProgramador> proyectosDeProgramadores, Proyecto proyecto){
        ProyectosDeProgramador proyectoPorAgregar = new ProyectosDeProgramador(proyecto);
        if (proyectosDeProgramadores.contains(proyectoPorAgregar)){
            proyectosDeProgramadores.get(proyectosDeProgramadores.indexOf(proyectoPorAgregar)).getProyectos().add(proyecto);
        } else {
            proyectosDeProgramadores.add(new ProyectosDeProgramador(proyecto));
        }
    }
    
}
