import java.util.Scanner;

public class ChecagemDeElementosDuplicados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] lista = in.split(" ");

        for (int i = 0; i < lista.length; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i].equals(lista[j])) System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}
