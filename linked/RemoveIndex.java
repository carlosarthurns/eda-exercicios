import java.util.*;

public class RemoveIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = converteInt(sc.nextLine().split(" "));
		int index = sc.nextInt();
		sc.nextLine();
	
		Linked ll = new Linked();

		for (int i = 0; i < arr.length; i++)
			ll.addLast(arr[i]);
		
		ll.remove(index);

		System.out.println(ll.toString());
	}

	private static int[] converteInt(String[] arr) {
		int[] out = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			out[i] = Integer.parseInt(arr[i]);
		
		return out;
	}
}

class Linked {
	private Node head;
	private Node tail;
	private int size;

	public Linked() {
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(int value) {
		Node newNode = new Node(value);	
	
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}

		this.size++;
	}

	public void removeFirst() {
		this.head = this.head.next;
		this.head.prev = null;

		this.size--;	
	}

	public void removeLast() {
		this.tail = this.tail.prev;
		this.tail.next = null;
		
		this.size--;
	}

	public void remove(int index) {
		if (index == 0) {
			removeFirst();
		} else if (index == this.size - 1) {
			removeLast();
		} else {
			Node curr = this.head;

			for (int i = 1; i <= index; i++)
				curr = curr.next;

			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;

			this.size--;
		}
	}	

	public String toString() {
		String out = "";
		Node curr = this.head;

		for (int i = 1; i < this.size; i++) {
			out += curr.value + " ";
			curr = curr.next;
		}

		out += this.tail.value;

		return out;
	}	
}

class Node {
	 Node prev;
	 Node next;
	 int value;

	public Node(int value) {
		this.value = value;
	}
}
