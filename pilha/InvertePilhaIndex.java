import java.util.*;

public class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tamanho = sc.nextInt();
        sc.nextLine();

        int[] lista = converteInt(sc.nextLine().split(" "));

        int index = sc.nextInt();
        sc.nextLine();
        
        System.out.println("-");

        Pilha p = new Pilha(tamanho);
        
        int i = 0;
        while (i != tamanho) {
            p.push(lista[i]);
            i++;
        }

        Pilha aux = new Pilha(index + 1);
        
        int j = 0;
        while (j <= index) {
            aux.push(p.pop());
            j++;
        }

        Pilha aux2 = new Pilha(index + 1);
        
        int k = 0;
        while (k <= index) {
            aux2.push(aux.pop());
            k++;
        }

        int l = 0;
        while (l <= index) {
            p.push(aux2.pop());
            l++;
        }

        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }
    }

    public static int[] converteInt(String[] array) {
        int[] out = new int[array.length];

        for (int i = 0; i < array.length; i++) {
           out[i] = Integer.parseInt(array[i]);
        }

        return out;
    }
}

class Pilha {

    private int[] pilha;
    private int top;
    private int cap;

    public  Pilha(int cap) {
        this.pilha = new int[cap];
        this.top = -1;
        this.cap = cap;
    }

    public int getTop() {
        return this.top;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.cap - 1;
    }

    public void push(int valor) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        
        this.pilha[++this.top] = valor;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");

        int num = this.pilha[this.top];
        this.top--;
        
        return num;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");

        return this.pilha[this.top];
    }
}

