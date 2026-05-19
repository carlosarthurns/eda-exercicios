import java.util.*;

public class Frequencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] lista = sc.nextLine().split(" ");
        int frequencia = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(n)) frequencia++;
        }

        System.out.println(frequencia);
    }
}
