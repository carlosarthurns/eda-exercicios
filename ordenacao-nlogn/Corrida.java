import java.util.*;

public class Corrida {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] pistaAna = new int[]{1, 3, 5, 7};
		int[] pistaBruno = new int[]{8,6,4,2,0};

		System.out.println(Arrays.toString(mergeCorrida(pistaAna, pistaBruno)));
	}

	public static int[] mergeCorrida(int[] pistaAna, int[] pistaBruno) {
		int i = 0;
		int k = 0;
		int j = pistaBruno.length - 1;

		int[] aux = new int[pistaAna.length + pistaBruno.length];

		while (i < pistaAna.length && j >= 0) {
			if (pistaAna[i] <= pistaBruno[j])
				aux[k++] = pistaAna[i++];
			else
				aux[k++] = pistaBruno[j--];
		}

		while (i < pistaAna.length) {
			aux[k++] = pistaAna[i++];
		}

		while (j >= 0) {
			aux[k++] = pistaBruno[j--];
		}

		return aux;
	}
}
