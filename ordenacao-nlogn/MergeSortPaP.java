import java.util.*;

public class MergeSortPaP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] lista = parseInt(sc.nextLine().split(" "));

        mergeSort(lista, 0, lista.length - 1);
    }

    public static void mergeSort(int[] v, int ini, int fim) {
        imprimeIntervalo(v, ini, fim);

        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, ini, meio);
            mergeSort(v, meio + 1, fim);
            merge(v, ini, fim);
        }
    }

    public static void merge(int[] v, int ini, int fim) {
        int[] aux = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            aux[i] = v[i];
        }
        
        int meio = (ini + fim) / 2;

        int i = ini;
        int j = meio + 1;
        int k = ini;

        while (i <= meio && j <= fim) {
            if (aux[i] <= aux[j])
                v[k] = aux[i++];
            else
                v[k] = aux[j++];
            k++;
        }

        while (i <= meio) {
            v[k++] = aux[i++];
        }
        
        imprimeIntervalo(v, ini, fim);
    }

    public static int[] parseInt(String[] v) {
        int[] out = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            out[i] = Integer.parseInt(v[i]);
        }

        return out;
    }

    public static void imprimeIntervalo(int[] v, int ini, int fim) {
        int tam = fim - ini + 1;
        int[] out = new int[tam];

        int j = 0;
        for (int i = ini; i <= fim; i++) {
            out[j++] = v[i];
        }

        System.out.println(Arrays.toString(out));
    }
}
