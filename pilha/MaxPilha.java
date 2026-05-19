import java.util.*;

public class MaxPilha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = converteInt(sc.nextLine().split(" "));
		int lim = sc.nextInt();
		sc.nextLine();
			
		Pilha p = new Pilha(arr.length);

		for (int i = 0; i < arr.length; i++)
			p.push(arr[i]);

		Pilha aux = new Pilha(lim + 1);
	
		int i = 0;
		int max = p.peek();
		while (i <= lim) {
			if (p.peek() > max) {
				max = p.peek();
				break;
			}
			aux.push(p.pop());
			i++;
		}

		while (aux.isEmpty()) {
			p.push(aux.pop());
		}

		System.out.println(max);
	}
	
	private static int[] converteInt(String[] arr) {
		int[] out = new int[arr.length];

		for (int i = 0; i < arr.length; i++) 
			out[i] = Integer.parseInt(arr[i]);

		return out;
	}
}

class Pilha {
	private int[] pilha;
	private int cap;
	private int top;

	public Pilha(int cap) {
		this.top = -1;
		this.pilha = new int[cap];
		this.cap = cap;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return this.top == this.cap -1;
	}

	public int peek() {
		if (isEmpty()) throw new NoSuchElementException("Pilha vazia!");

		return this.pilha[this.top];
	}

	public int pop() {
		if (isEmpty()) throw new NoSuchElementException("Pilha vazia!");

		int num = this.pilha[this.top];
		this.top--;

		return num;
	}

	public void push(int value) {
		if (isFull()) throw new NoSuchElementException("Pilha cheia!");

		this.top++;
		this.pilha[this.top] = value;
	}
}
