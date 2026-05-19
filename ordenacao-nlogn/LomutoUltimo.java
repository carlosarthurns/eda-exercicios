import java.util.*;

public class LomutoUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = parseInt(sc.nextLine().split(" "));

        int i = v.length - 1;
        int j = v.length - 2;
        int pivot = v[v.length - 1];

        while (j >= 0) {
            if (v[j] >= pivot) {
                i--;
                swap(v, i, j);
                System.out.println(Arrays.toString(v));
            }
            j--;
        }
        swap(v, i, v.length - 1);
        System.out.println(Arrays.toString(v));

        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static int[] parseInt(String[] v) {
        int[] out = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            out[i] = Integer.parseInt(v[i]);
        }

        return out;
    }
}

