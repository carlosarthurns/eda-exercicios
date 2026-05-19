import java.util.*;

public class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        for (int i = 0; i < lista.length - 1; i += 2) {
            String pos = lista[i];
            lista[i] = lista[i + 1];
            lista[i + 1] = pos;
        }

        System.out.println(Arrays.toString(lista));
    }
}
