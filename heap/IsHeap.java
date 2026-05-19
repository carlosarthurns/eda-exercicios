import java.util.*;

class IsHeap {
    private int[] heap;
    private int tail;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");

        IsHeap isHeap = new IsHeap(values.length);

        for (String v : values) {
            if (isHeap.add(Integer.parseInt(v))) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public IsHeap(int cap) {
        this.heap = new int[cap];
        this.tail = -1;
    }

    public boolean add(int v) {
        this.heap[++this.tail] = v;

        int i = this.tail;
        if (this.heap[parent(i)] < this.heap[i])
            return true;
        return false;
    }
}
