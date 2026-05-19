import java.util.*;

public class InserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	String entrada = sc.nextLine();

	int[] lista = Arrays.stream(entrada.split(" ")).mapToInt(Integer::parseInt).toArray();

	int i = 0;
	while (i < lista.length - 1 && lista[i] > lista[++i]) {
	    int aux = lista[i];
	    lista[i] = lista[i - 1];
	    lista[i - 1] = aux;
	}


	System.out.println(Arrays.toString(lista));
    }
}
