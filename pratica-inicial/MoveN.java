import java.util.*;

public class MoveN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        for (int i = 0; i < lista.length - 1; i++)
            if (converteEmInt(lista[i]) > converteEmInt(lista[i + 1])) {
                ordenaLista(lista, i + 1);
            }
    }

    private static void ordenaLista(String[] lista, int indice) {
        for (int i = indice; i > 0; i--) {
            if (converteEmInt(lista[i]) > converteEmInt(lista[i - 1])) break;
            
            String aux = lista[i - 1];
            lista[i - 1] = lista[i];
            lista[i] = aux;

            System.out.println(Arrays.toString(lista));
        }
    }

    private static int converteEmInt(String elem) {
        return Integer.parseInt(elem);
    }
}
