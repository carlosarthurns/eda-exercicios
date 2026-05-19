import java.util.*;

public class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lista = parseInt(sc.nextLine().split(" "));
        int[] indices = parseInt(sc.nextLine().split(" "));

        int menoresPivotUm = 0;
        int maioresPivotUm = 0;

        int menoresPivotDois = 0;
        int maioresPivotDois = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] < lista[indices[0]])
                menoresPivotUm++;
            if (lista[i] > lista[indices[0]])
                maioresPivotUm++;
            if (lista[i] < lista[indices[1]])
                menoresPivotDois++;
            if (lista[i] > lista[indices[1]])
                maioresPivotDois++;
        }

        int difPivotUm = Math.abs(maioresPivotUm - menoresPivotUm);
        int difPivotDois = Math.abs(maioresPivotDois - menoresPivotDois);

        if (difPivotUm <= difPivotDois)
            System.out.println(indices[0]);
        else
            System.out.println(indices[1]);
    }

    public static int[] parseInt(String[] v) {
        int[] out = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            out[i] = Integer.parseInt(v[i]);
        }

        return out;
    }
}
