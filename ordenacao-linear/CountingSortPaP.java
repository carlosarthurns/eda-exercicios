import java.util.*;

public class CountingSortPaP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] v = parseInt(sc.nextLine().split(" "));
        int k = sc.nextInt();

        int[] c = new int[k + 1];

        for (int i = 0; i < v.length; i++) {
            c[v[i]]++;
            imprimeArray(c);
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        System.out.print("Cumulativa do vetor de contagem - ");
        imprimeArray(c);

        int[] b = new int[v.length];

        for (int j = v.length - 1; j >= 0; j--) {
            b[c[v[j]] - 1] = v[j];
            c[v[j]]--;
        }

        imprimeArray(c);
        imprimeArray(b);
    }

    public static void imprimeArray(int[] array) {
        String out = "";

        for (int i = 0; i < array.length; i++) {
            out += array[i] + " ";
        }

        System.out.println(out.trim());
    }

    public static int[] parseInt(String[] array) {
        int[] out = new int[array.length];

        for (int i = 0; i < array.length; i++) {
           out[i] = Integer.parseInt(array[i]);
        }

        return out;
    }
}
