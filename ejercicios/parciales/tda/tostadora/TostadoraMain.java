package parciales.tda.tostadora;

public class TostadoraMain {
    public static void main(String[] args) {
        Tostadora tostadora = new Tostadora(4); // Tostadora de 4 ranuras
        
        tostadora.prenderTostadora();
        tostadora.indicarNivelDeCalor(6);
        
        // Asumiendo que modificás el método para recibir el índice entero (int)
        tostadora.iniciarTostado(0); 
        tostadora.iniciarTostado(2);
        
        System.out.println("Ranuras libres: " + tostadora.contarRanurasLibres());
        
        tostadora.finalizarTostado(0);
        tostadora.apagarTostadora();
    }
}
