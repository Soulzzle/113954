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

    /**
     * registrar inserta un nuevo préstamo en el sistema.
     * Si se alcanza la capacidad máxima del arreglo, su tamaño se duplica.
     * @param p el préstamo a registrar.
     * @throws NullPointerException si el préstamo es nulo.
     */
    @Override 
    public void registrar(Prestamo p){
        Objects.requireNonNull(p, "El prestamo a registrar no puede ser nulo.");

        if(this.cantidad == this.prestamos.length){
            this.prestamos = Arrays.copyOf(this.prestamos, this.prestamos.length * 2);
        }
        this.prestamos[cantidad] = p;
        this.cantidad++;
    }

    /**
     * cantidad informa cuántos préstamos efectivos hay guardados.
     * @return la cantidad de préstamos del registro.
     */
    @Override 
    public int cantidad(){
        return this.cantidad;
    }

    /**
     * obtener devuelve un préstamo por su índice de inserción.
     * @param i la posición del préstamo.
     * @return el préstamo correspondiente a la posición i.
     * @throws IndexOutOfBoundsException si i está fuera del rango lógico actual.
     */
    @Override
    public Prestamo obtener(int i){ // IndexOutOfBoundsException si i es invalido
        if (i < 0 || i > this.cantidad-1){
            throw new IndexOutOfBoundsException("i tiene que estar dentro del rango.");
        }

        return this.prestamos[i];
    }

    /**
     * padronYaAnotado verifica si un número de socio ya fue contabilizado en la extracción.
     * @param padrones el arreglo auxiliar con los padrones únicos.
     * @param padronActual el padrón a verificar.
     * @param topePadrones la cantidad de padrones validados hasta el momento.
     * @return true si el padrón existe, false en caso contrario.
     */
    private static boolean padronYaAnotado(int[] padrones, int padronActual, int topePadrones){
        for (int i = 0; i < topePadrones; i++){
            if (padrones[i] == padronActual){
                return true;
            }
        }
        return false;
    }

    /**
     * padrones recupera la lista de todos los socios que tienen al menos un préstamo.
     * @return un arreglo con los padrones únicos ordenados cronológicamente por aparición.
     */
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

    /**
     * prestamosDe extrae todos los préstamos vinculados a un socio específico.
     * @param padron el número de socio a buscar.
     * @return un arreglo con las coincidencias, o un arreglo vacío si no hay registros.
     */
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

    /**
     * ordenaTitulosPorCantidad aplica el ordenamiento paralelo sobre títulos y frecuencias.
     * La regla establece prioridad por mayor demanda, con desempate alfabético.
     * @param contador el arreglo con las frecuencias.
     * @param titulos el arreglo con los nombres de los libros.
     * @param topeTitulos el tamaño lógico de ambos arreglos.
     */
    private static void ordenaTitulosPorCantidad(int[] contador, String[] titulos, int topeTitulos){
        for (int i = 0; i < topeTitulos; i++){
            for (int j = 0; j < topeTitulos-i-1; j++){
                boolean seCambian = false;
                if (contador[j] < contador[j+1]){
                    seCambian = true;                   
                } else if (contador[j] == contador[j+1]){
                    if (titulos[j].compareTo(titulos[j+1]) > 0){
                        seCambian = true;
                    }
                }
                if (seCambian) {
                    String tituloAux = titulos[j];
                    int contadorAux = contador[j];
                    titulos[j] = titulos[j+1];
                    titulos[j+1] = tituloAux;
                    contador[j] = contador[j+1];
                    contador[j+1] = contadorAux; 
                } 
            }
        }
    }

    /**
     * titulosMasPedidos devuelve un ranking con los títulos más solicitados de la biblioteca.
     * @param n la cantidad máxima de posiciones a devolver.
     * @return un arreglo recortado con el ranking de los títulos.
     */
    @Override
    public String[] titulosMasPedidos(int n){ // los n mas pedidos, desempate alfabetico
        String[] titulos = new String[this.cantidad];
        int[] contadores = new int[this.cantidad];
        int topeTitulos = 0;
        
        // Primero busco en this.prestamos con un for y escribo todos los títulos, 
        // sumando a contador (en el índice equivalente a titulos) cada aparición con otro for.
        for (int i = 0; i < this.cantidad; i++){
            String tituloActual = this.prestamos[i].titulo();
            boolean tituloYaAnotado = false;
            for (int j = 0; j < topeTitulos; j++){
                if (tituloActual.equals(titulos[j])){
                    tituloYaAnotado = true;
                    contadores[j]++;
                }
            }
            if (!tituloYaAnotado){
                titulos[topeTitulos] = tituloActual;
                contadores[topeTitulos]++;
                topeTitulos++;
            }
        }

        // Ahora ordeno los titulos por sus contadores y luego alfabeticamente.
        ordenaTitulosPorCantidad(contadores, titulos, topeTitulos);
        
        int cantTitulos = Math.min(n, topeTitulos);
        titulos = Arrays.copyOf(titulos, cantTitulos);
        return titulos;
    }
}
