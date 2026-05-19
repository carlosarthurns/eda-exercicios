import java.util.*;

public class MoveImpostor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] lista = sc.nextLine().split(" ");
        
        for (int i = 0; i < lista.length - 1; i++) {
            if (converte(lista[i]) > converte(lista[i + 1])) {
                moveImpostor(lista, i);
                break;
            }
        }

        System.out.println(Arrays.toString(lista));
    }
    private static int converte(String num) {
        return Integer.parseInt(num);
    }

    private static void moveImpostor(String[] lista, int idx) {
        for (int i = idx; i >= 0; i--) {
            if (converte(lista[i]) > converte(lista[i + 1])) {
                String aux = lista[i];
                lista[i] = lista[i + 1];
                lista[i + 1] = aux;
            }
        }
    }
}
