import java.util.*;

public class InsereUltimo {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String entrada = sc.nextLine();

	int[] lista = Arrays.stream(entrada.split(" ")).mapToInt(Integer::parseInt).toArray();

	int i = lista.length - 1;
	while (i > 0 && lista[i] < lista[i - 1]) {
	    int aux = lista[i - 1];
	    lista[i - 1] = lista[i];
	    lista[i] = aux;
	    i--;
        }

	System.out.println(Arrays.toString(lista));
    }
}
