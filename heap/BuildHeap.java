import java.util.*;

class BuildHeap {
    private int tail;
    private int[] heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = sc.nextLine().split(" ");

        int[] values = new int[lista.length];

        for (int i = 0; i < lista.length; i++)
            values[i] = Integer.parseInt(lista[i]);

        BuildHeap heap = new BuildHeap(values);
        System.out.println(heap.toString());
    }

    public BuildHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    private void buildHeap() {
        for (int i = parent(tail); i >= 0; i--)
            heapify(i);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index*2 + 1;
    }

    private int right(int index) {
        return index*2 + 2;
    }

    private boolean isLeaf(int i) {
        return i > parent(this.tail) && i <= this.tail;
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i <= tail;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) return;

        int max = maxIndex(index, left(index), right(index));

        if (max != index) {
            swap(index, max);
            heapify(max);
        }
    }

    private int maxIndex(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            }
            return index;
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right]) 
                    return right;
            }
            return left;
        }
    }
}
