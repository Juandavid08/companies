import java.util.*;

public class cadena {

    private static final Set<String> palabras = new HashSet<>(Arrays.asList(
        "fgh", "hup", "qsd", "fghu", "sxc", "fgk"
    ));

    public static void main(String[] args) {
        char[] cadena = {
            'w','e','r','f','b','h','j','i','u','y','t','r','e','d','f','g','y','u','i','o','l','k','m','n','b','v','f','r','e','w','s','x','f','g','y','u','i','k','m','n','b','v','f','r','e','w','w','r','t','y','u','i','o','k','m','n','b','v','w','s','x','c','f','g','h','u','i','o','p','l','k','n','b','v','f','d','e','w','a','z','x','c','g','h','u','i','o','p','u','y','t','r','e','w','q','s','d','f','g','k','j','v','c','x'
        };

        Set<String> palabrasGeneradas = generarPalabras(cadena);

        System.out.println("Las palabras encontradas son:");
        for (String palabra : palabrasGeneradas) {
            System.out.println(palabra);
        }
    }

    public static Set<String> generarPalabras(char[] cadena) {
        Set<String> resultados = new HashSet<>();
        int maxLongitud = 5;

        for (int i = 0; i < cadena.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < Math.min(cadena.length, i + maxLongitud); j++) {
                sb.append(cadena[j]);
                String posible = sb.toString().toLowerCase();
                if (palabras.contains(posible)) {
                    resultados.add(posible);
                }
            }
        }

        return resultados;
    }
}
