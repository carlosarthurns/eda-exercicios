
public class Parenteses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String parent = sc.nextLine();
		
		Pilha p = new Pilha(parent.length());
		
		for (int i = 0; i < parent.length(); i++) {
			p.push(parent.charAt(i));
		}	
		
		int abertos = 0;
		
		Pilha newP = new Pilha(parent.length());

		while (!p.isEmpty()) {

			if (p.peek() == '(' && abertos == 0) {
				abertos = -1; 
				break;
			}
			
			if (p.peek() == '(') {
				abertos++;
			} else {
				abertos--;
			}

			newP.push(p.pop());
		} 

		while (!newP.isEmpty()) {
			p.push(newP.pop());
		}

		if (abertos == 0) System.out.println("S");
		else System.out.println("N");
	}
}

class Pilha {
	private char[] pilha;
	private int cap;
	private int top;

	public Pilha(int cap) {
		this.cap = cap;
		this.top = -1;
		this.pilha = new char[cap];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == this.cap - 1;
	}

	public char pop() {
		if (isEmpty()) throw new NoSuchElementException("Pilha vazia!");

		char charactere = this.pilha[this.top--];

		return charactere;
	}

	public char peek() {
		if (isEmpty()) throw new NoSuchElementException("Pilha vazia!");
		
		return this.pilha[this.top];
	}

	public void push(char value) {
		if (isFull()) throw new RuntimeException("Pilha cheia!");

		this.pilha[++this.top] = value;
	}
}
