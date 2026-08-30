// Hola con tu nombre. Escribí un programa que imprima un saludo con tu nombre y tu legajo.
class saludo {
    public static String saludar(String nombre, int padron){
        return "Hola, soy " + nombre + " y mi padrón es " + String.valueOf(padron);
    }

    public static void main(String[] args) {
        String nombre = "Danel";
        int padron = 113954;
        System.out.println(saludar(nombre, padron));
    }
}
