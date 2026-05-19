import java.util.*;

public class MoveTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] lista = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            lista[i] = Integer.parseInt(entrada[i]);
        }
        
        for (int k = 1; k <= 3; k++){
            for (int j = 0; j < entrada.length; j++) {
                if (lista[j] > lista[j + 1]) {
                    ordenaLista(lista, j);
                    break;
                }
            }
        }
    }

    public static void ordenaLista(int[] lista, int idx) {
        for (int i = idx; i >= 0; i--) {
            if (lista[i] < lista[i + 1]) return;
            
            int aux = lista[i];
            lista[i] = lista[i + 1];
            lista[i + 1] = aux;
    
            System.out.println(Arrays.toString(lista));
        }
    }
}
