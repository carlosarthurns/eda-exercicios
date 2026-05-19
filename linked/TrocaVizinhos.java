import java.util.*;

public class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = parseInt(sc.nextLine().split(" "));
		int index = sc.nextInt();
		sc.nextLine();

		LinkedList ll = new LinkedList();
	
		for (int i = 0; i < v.length; i++) {
			ll.addLast(v[i]);
		}

		ll.swapNeighbors(index);
		
		System.out.println(ll.toString());

    }

    public static int[] parseInt(String[] array) {
        int[] out = new int[array.length];

        for (int i = 0; i < array.length; i++) {
           out[i] = Integer.parseInt(array[i]);
        }

        return out;
    }
}

class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	public LinkedList(){}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(int value) {

		Node newNode = new Node(value);

		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}		
		
		this.size++;
	}

	public void swapNeighbors(int index) {
		Node curr = this.head;

		for (int i = 1; i <= index; i++)
			curr = curr.next;

		Node aux = curr.next;

		curr.next = aux.next;
		aux.next.prev = curr;
		aux.next = curr;

		aux.prev = curr.prev;
		curr.prev.next = aux;
		curr.prev = aux;
	}

	public String toString() {
		String out = "";

		Node curr = this.head;
		
		for (int i = 1; i <= this.size; i++) {
			out += curr.value + " ";
			curr = curr.next;
		}		

		return out.trim();
	}
}

class Node {
	Node next;
	Node prev;
	int value;
	
	public Node (int value) {
		this.value = value;
	}
}
