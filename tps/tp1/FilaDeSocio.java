package tp1;

public record FilaDeSocio(int padron, String socio, int prestamos, int diasDeAtraso, int multa, String estado) implements Comparable<FilaDeSocio> {
    @Override
    public int compareTo(FilaDeSocio otra) {
        if (this.multa != otra.multa) {
            return Integer.compare(otra.multa, this.multa); 
        }
        return this.socio.compareTo(otra.socio); 
    }
}
