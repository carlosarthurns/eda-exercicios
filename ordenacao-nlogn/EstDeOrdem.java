import java.util.*;

public class EstDeOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = parseInt(sc.nextLine().split(" "));

        int i = 0;
        int ordem = 1;
        
        for (int j = 1; j < v.length; j++) {
            if (v[j] < v[0]) {
                ordem++;
                i++;
                swap(v, i, j);
            }
        }

        swap(v, 0, i);

        System.out.println(ordem);
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static int[] parseInt(String[] a) {
        int[] out = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            out[i] = Integer.parseInt(a[i]);
        }

        return out;
    }
}
