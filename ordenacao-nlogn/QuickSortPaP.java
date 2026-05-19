import java.util.*;

public class QuickSortPaP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lista = parseInt(sc.nextLine().split(" "));

        quickSort(lista, 0, lista.length - 1);
    }

    public static void quickSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int pivot = particiona(v, ini, fim);

            imprimeArrayFormatado(v);

            quickSort(v, ini, pivot - 1);
            quickSort(v, pivot + 1, fim);
        }
    }

    public static int particiona(int[] v, int ini, int fim) {
        int pivot = v[ini];

        int i = ini;
        int j = ini + 1;

        while (j <= fim) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
            j++;
        }
        
        swap(v, ini, i);


        return i;
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void imprimeArrayFormatado(int[] v) {
        String out = "";

        for(int i = 0; i < v.length; i++) {
            out += v[i] + " ";
        }

        System.out.println(out.trim());
    }

    public static int[] parseInt(String[] lista) {
        int[] out = new int[lista.length];

        for (int i = 0; i < lista.length; i++) {
            out[i] = Integer.parseInt(lista[i]);
        }

        return out;
    }
}
