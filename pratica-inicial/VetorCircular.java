import java.util.*;

public class VetorCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] lista = sc.nextLine().split(" ");
        
        int inteiroN = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < inteiroN; i++) {
            System.out.print(lista[i % lista.length] + " ");
        }
    }
}
