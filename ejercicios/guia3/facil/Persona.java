package guia3.facil;

// Orden natural. Clase Persona que implemente Comparable por edad; test del orden.
public class Persona implements Comparable<Persona> {
    // ATRIBUTOS
    private String nombre;
    private int edad;

    // CONSTRUCTORES
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override 
    public int compareTo(Persona persona){
        return Integer.compare(this.edad, persona.edad);
    }

    // GETTERS
    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }
}
