import java.util.*;

public class SelectionSortPaP {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int[] lista = converte(sc.nextLine().split(" "));

        selectionSort(lista);
    }

    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int indexMenor = i;

            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[indexMenor])
                    indexMenor = j;
            }

            swap(v, indexMenor, i);
            
            if (indexMenor != i)
                System.out.println(Arrays.toString(v));
        }
    }

    public static void swap(int[] v, int j, int i) {
        int aux = v[j];
        v[j] = v[i];
        v[i] = aux;
    }

    public static int[] converte(String[] array) {
    	int[] out = new int[array.length];

	    for (int i = 0; i < array.length; i++) {
 	        out[i] = Integer.parseInt(array[i]);
	    }

	    return out;
    }
}
