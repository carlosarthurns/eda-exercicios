import java.util.*;

public class Posicoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String elem = sc.nextLine();

        String[] lista = sc.nextLine().split(" ");
        Set<Integer> posicoes = new HashSet<>();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(elem)) {
                posicoes.add(i);
            }
        }
        
        if (posicoes.size() == 0) {
            System.out.println("-1");
        } else {
            for (int i : posicoes) {
                if (i + 1 > posicoes.size()) {
                    System.out.print(i);
                } else {
                    System.out.print(i + " ");
                }
            }
        }
    }
}

