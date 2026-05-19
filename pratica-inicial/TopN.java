import java.util.*;

public class TopN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] lista = converte(sc.nextLine().split(" "));
        
        int n = sc.nextInt();
        sc.nextLine();
      
        for (int i = 0; i < n; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    private static int[] converte(String[] lista) {
        int[] retorno = new int[lista.length];

        for (int i = 0; i < lista.length; i++) {
            retorno[i] = Integer.parseInt(lista[i]);
            ordena(retorno, i);
        }

        return retorno;
    }

    public static void ordena(int[] lista, int idx) {
        for (int i = idx; i > 0; i--) {
            if (lista[i] > lista[i - 1]) {
                int aux = lista[i];
                lista[i] = lista[i - 1];
                lista[i - 1] = aux;
            }
        }
    }
}
