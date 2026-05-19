import java.util.*;

public class DownN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lista = converteEmInt(sc.nextLine().split(" "));
        int numN = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numN; i++)
            System.out.print(lista[i] + " ");

        System.out.println();
    }

    public static int[] converteEmInt(String[] lista) {
        int[] retorno = new int[lista.length];

        for (int i = 0; i < lista.length; i++) {
            retorno[i] = Integer.parseInt(lista[i]);
            insereOrdenado(retorno, i);
        }

        return retorno;
    }

    public static void insereOrdenado(int[] lista, int indice) {
        for (int i = indice; i > 0; i--)
            if (lista[i] < lista[i - 1]) {
                int aux = lista[i - 1];
                lista[i - 1] = lista[i];
                lista[i] = aux;
            }
    }
}
