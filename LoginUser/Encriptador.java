public class Encriptador {

    private static final String ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CIFRADO = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    public static String encriptar(String frase) {
        frase = frase.toUpperCase();
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            int indice = ABECEDARIO.indexOf(letra);
            if (indice != -1) {
                letra = CIFRADO.charAt(indice);
            }
            resultado.append(letra);
        }
        return resultado.toString();
    }
    
}