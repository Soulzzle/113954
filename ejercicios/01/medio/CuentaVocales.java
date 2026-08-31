// Contar vocales. Dado un String, contá cuántas vocales tiene (recorré con un for y charAt).
public class CuentaVocales {

    /**
     * cantidadVocales cuenta las letras vocales en el string s.
     * @param s El string recibido.
     * @return contador tipo int con la cantidad de letras vocales en s.
     */
    public static int cantidadVocales(String s){
        if (s==null){
            return 0;
        }
        int contador = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args){
        String s = "HolA";
        int c = cantidadVocales(s);
        System.out.println("La cantidad de vocales en " + s + " son: " + c);
    }
}