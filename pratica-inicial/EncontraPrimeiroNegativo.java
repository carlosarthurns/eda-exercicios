import java.util.*;

public class EncontraPrimeiroNegativo {
    public static String achaPrimeiroNegativo(String[] lista, int indice) {
        if (indice == lista.length) return "-";
        if (Integer.parseInt(lista[indice]) < 0) return lista[indice];

        return achaPrimeiroNegativo(lista, ++indice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] lista = sc.nextLine().split(" ");
        
        System.out.println(achaPrimeiroNegativo(lista, 0));
    }
}

