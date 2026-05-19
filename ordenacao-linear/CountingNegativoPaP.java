import java.util.*;

public class CountingNegativoPaP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = parseInt(sc.nextLine().split(" "));
        int maior = sc.nextInt(); sc.nextLine();
        int menor = sc.nextInt(); sc.nextLine();

        int quantElemPossiveis = maior + Math.abs(menor) + 1;

        int[] c = new int[quantElemPossiveis];

        for (int i = 0; i < v.length; i++) {
            c[v[i] - menor]++;
            System.out.println(Arrays.toString(c));
        }
        
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j - 1];
        }

        System.out.println("Culmutativa do vetor de contagem - " + Arrays.toString(c));

        int[] b = new int[v.length];

        for (int k = v.length - 1; k >= 0; k--) {
            b[c[v[k] - menor] - 1] = v[k];
            c[v[k] - menor]--;
        }

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(b));
    }

    public static int[] parseInt(String[] array) {
        int[] out = new int[array.length];

        for (int i = 0; i < array.length; i++) {
           out[i] = Integer.parseInt(array[i]);
        }

        return out;
    }
}
