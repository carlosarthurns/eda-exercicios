import java.util.*;

public class Mariana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(",");

        System.out.println(formata(entrada));

        for (int i = 1; i < entrada.length; i++) {
            if (entrada[i].compareTo(entrada[i - 1]) < 0) {
                insereOrdenado(entrada, i);
            }
            System.out.println(formata(entrada));
        }
    }

    public static void insereOrdenado(String[] lista, int index) {
        while (index > 0 && lista[index].compareTo(lista[index - 1]) < 0) {
            String aux = lista[index]; 
            lista[index] = lista[index - 1];
            lista[index-- - 1] = aux;
        }
    }

    public static String formata(String[] lista) {
        String out = "";

        for (int i = 0; i < lista.length - 1; i++) {
            out += lista[i] + ", ";
        }
        
        out += lista[lista.length - 1];

        return out;
    }
}
