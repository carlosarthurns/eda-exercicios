import java.util.*;

public class InsertionSortRecursivo {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String[] entrada = sc.nextLine().split(" ");

	    int[] lista = converte(entrada);

	    for (int i = 1; i < lista.length; i++) {
	        insertion(lista, i);
	        System.out.println(Arrays.toString(lista));
	    }
    }

    private static int[] converte(String[] lista) {
	    int[] out = new int[lista.length];

	    for (int i = 0; i < lista.length; i++) {
	        out[i] = Integer.parseInt(lista[i]);
	    }

	    return out;
    }

    private static void insertion(int[] lista, int i) {
	    if (i <= 0 || lista[i] > lista[i - 1])
	        return;
	    else {
	        int aux = lista[i];
	        lista[i] = lista[i - 1];
	        lista[i - 1] = aux;
	        insertion(lista, --i);
	    }
    }
}


