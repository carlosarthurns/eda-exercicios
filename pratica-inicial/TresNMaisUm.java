import java.util.Scanner;

public class TresNMaisUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int qtdSeq = 0;
        int num1 = sc.nextInt();
        sc.nextLine();

        int qtdSeq2 = 0;
        int num2 = sc.nextInt();
        sc.nextLine();

        while (num1 != 1) {
            if (num1 % 2 == 0) {
                num1 /= 2;
                qtdSeq++;
            } else {
                num1 = 3 * num1 + 1;
                qtdSeq++;
            }
        }

        while (num2 != 1) {
            if (num2 % 2 == 0) {
                num2 /= 2;
                qtdSeq2++;
            } else {
                num2 = 3 * num2 + 1;
                qtdSeq2++;
            }
        }

        System.out.println(Math.max(qtdSeq, qtdSeq2));
    }
}
